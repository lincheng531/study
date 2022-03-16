package com.lincheng.study.quartz.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 17:42
 **/
public class TestJob {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","job1group1")
                .usingJobData("job","jobDeatil1")
                .usingJobData("name","jobDeatil1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1","triggergroup1")
                .usingJobData("trigger","trigger1")
                //.usingJobData("name","trigger1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
