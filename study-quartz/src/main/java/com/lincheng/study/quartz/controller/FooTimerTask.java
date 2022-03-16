package com.lincheng.study.quartz.controller;

import com.lincheng.study.common.utils.DateUtils;

import java.util.Date;
import java.util.TimerTask;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 16:55
 **/
public class FooTimerTask extends TimerTask {

    private String taskName;

    public FooTimerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("name=" + taskName + "---" + "startTime=" + DateUtils.dateToString(new Date()));
            Thread.sleep(3000);
            System.out.println("name=" + taskName + "---" + "endTime=" + DateUtils.dateToString(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
