package com.lincheng.study.quartz.controller;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 17:25
 **/
public class ScheduleThreadPoolTest {


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new PoolTask("poolTask" + i),0,2000, TimeUnit.SECONDS);
        }
    }
}
