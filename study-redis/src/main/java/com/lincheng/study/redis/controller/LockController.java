package com.lincheng.study.redis.controller;

import com.lincheng.study.redis.utils.RedissonUtils;
import org.redisson.api.RLock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-11-18 16:10
 **/
@RestController
public class LockController {


    @RequestMapping(value = "/testUtil")
    public Object testUtil() throws Exception{
        Object age = RedissonUtils.getString("age");
       return age;
    }


    //不加锁的情况
    @RequestMapping(value = "/noRedission", method = RequestMethod.POST)
    public String testNoRedission() throws Exception{
        workMethod();
        return "执行成功！";
        /*
        result:
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============睡眠结束啦啦啦啦啦啦=============
                ============睡眠结束啦啦啦啦啦啦=============
                ============睡眠结束啦啦啦啦啦啦=============
        */

    }


    //Redission三行代码基于Redis实现分布式锁的加锁与释放锁
    @RequestMapping(value = "/redission", method = RequestMethod.POST)
    public String testRedission() {
        RLock lock = RedissonUtils.getRLock("LockTest");
        lock.lock();
        try {
            workMethod();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "执行成功！";

        /*
        result:
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============睡眠结束啦啦啦啦啦啦=============
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============睡眠结束啦啦啦啦啦啦=============
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============睡眠结束啦啦啦啦啦啦=============
        */
    }


    //使用trylock()模式
    @RequestMapping(value = "/redission2", method = RequestMethod.POST)
    public String testRedission2() throws Exception {
        RLock lock = RedissonUtils.getRLock("LockTest");
        if(lock.tryLock()){
            workMethod();
            lock.unlock();
            return "执行成功！";
        }else {
            return "已经有请求在执行，该请求获取不到锁，直接退出！";
        }
         /*
         result:
                ============reidsson 起效果了吗？可以进入到这个方法吗？？？？=============
                ============睡眠结束啦啦啦啦啦啦=============
        */
    }



    private void workMethod() throws Exception{
        System.out.println("============reidsson 起效果了吗？ 可以进入到这个方法吗？？？？=============");
        Thread.sleep(2000);
        System.out.println("============睡眠结束啦啦啦啦啦啦=============");
    }

}
