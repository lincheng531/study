package com.lincheng.study.redis;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class StudyRedisApplicationTests {

    @Resource
    private RedissonClient redissonClient;


    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    public void string() {
        RBucket<Object> bucket = redissonClient.getBucket("name:1", StringCodec.INSTANCE);
        Object o = bucket.get();
        System.out.println(o);

        RBucket<Object> result = redissonClient.getBucket("name:1", StringCodec.INSTANCE);
        result.set("哈哈哈");
    }

    @Test
    public void string2() {
        RBucket<Object> result = redissonClient.getBucket("name:2", StringCodec.INSTANCE);
        result.set("哈哈哈2222");

        RBucket<Object> result2 = redissonClient.getBucket("name:1", StringCodec.INSTANCE);
        result2.set("1111111111");
    }

    @Test
    public void stringDelete() {
        RKeys keys = redissonClient.getKeys();
        long deletedKeysAmount = keys.deleteByPattern("name:*");
        System.out.println(deletedKeysAmount);
    }


    @Test
    public void hashes() {
        //RMap<Object, Object> studySetString = redissonClient.getMap("studySetString", StringCodec.INSTANCE);
        // 通过key获取RMap
        RMap<String, String> studentRMap = redissonClient.getMap("studentMap");
        // 设置map中key-value
        studentRMap.put("id", "123");
        studentRMap.put("name", "赵四");
        studentRMap.put("age", "50");

        // 设置key有效期
        //studentRMap.expire(300, TimeUnit.SECONDS);
        // 通过key获取value
        RMap<Object, Object> studentMap = redissonClient.getMap("studentMap");
        System.out.println(JSON.toJSONString(studentMap));
        Object o = redissonClient.getMap("studentMap").get("name");
        System.out.println(JSON.toJSONString(o));

    }


    @Test
    public void lists() {
        RList<Object> rList = redissonClient.getList("studentList");

        rList.add(1);
        rList.add(2);
        rList.add("哈哈哈");


        // 设置有效期
        rList.expire(300, TimeUnit.SECONDS);
        // 通过key获取value
        Object studentList = redissonClient.getList("studentList").get(0);
        System.out.println(JSON.toJSONString(studentList));
        RList<Object> studentList1 = redissonClient.getList("studentList");
        System.out.println(JSON.toJSONString(studentList1));
    }


    @Test
    public void sets() {
        RSet<Object> studentRSet = redissonClient.getSet("studentSet");
        studentRSet.add("jack");
        studentRSet.add("tom");
        // 设置有效期
        //studentRSet.expire(300, TimeUnit.SECONDS);
        // 通过key获取value
        redissonClient.getSet("studentSet");
    }



    @Test
    public void sortedSets() {
        RSortedSet<Object> studentSortedSet = redissonClient.getSortedSet("studentSortedSet");
        studentSortedSet.add("jack");
        studentSortedSet.add("tom");
// 通过key获取value
        redissonClient.getSortedSet("studentSortedSet");
    }







}



