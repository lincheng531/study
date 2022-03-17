package com.lincheng.study.quartz.task;

import com.lincheng.study.quartz.entity.TaskScheduleJob;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-17 16:35
 **/
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        Object taskScheduleJob1 = mergedJobDataMap.get("TaskScheduleJob");
        System.out.println(taskScheduleJob1);
        TaskScheduleJob taskScheduleJob = (TaskScheduleJob) context.getMergedJobDataMap().get("TaskScheduleJob");
        TaskUtils.invokMethod(taskScheduleJob);
    }
}
