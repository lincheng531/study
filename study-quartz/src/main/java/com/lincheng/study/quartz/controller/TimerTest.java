package com.lincheng.study.quartz.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 16:53
 **/
@RestController
public class TimerTest {


    public static void main(String[] args) {
        //任务启动
        Timer timer = new Timer();
        for (int i = 0; i < 2; i++) {
            TimerTask task = new FooTimerTask("foo" +i);
            //任务添加
            //出现bug的问题在于单线程,需要等待、
            //少执行
            timer.schedule(task,new Date(),2000);
            //执行时间会乱
            //timer.scheduleAtFixedRate(task,new Date(),2000);
        }
    }
}
