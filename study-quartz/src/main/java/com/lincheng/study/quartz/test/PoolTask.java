package com.lincheng.study.quartz.test;

import com.lincheng.study.common.utils.DateUtils;

import java.util.Date;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 16:55
 **/
public class PoolTask implements Runnable {

    private String taskName;

    public PoolTask(String taskName) {
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
