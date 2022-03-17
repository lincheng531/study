package com.lincheng.study.quartz.task;

import com.lincheng.study.quartz.entity.TaskScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-17 16:34
 **/
public class QuartzJobFactory implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        TaskScheduleJob scheduleJob = (TaskScheduleJob) context.getMergedJobDataMap().get("TaskScheduleJob");
        TaskUtils.invokMethod(scheduleJob);
    }
}
