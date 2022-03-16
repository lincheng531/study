package com.lincheng.study.quartz.test;

import com.lincheng.study.common.utils.DateUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @description:
 * @author: linCheng
 * @create: 2022-03-16 17:41
 **/
public class MyJob implements Job {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDetailJobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jriggerJobDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("jobDetailJobDataMap:" + jobDetailJobDataMap.getString("job"));
        System.out.println("jobDetailJobDataMap:" + jriggerJobDataMap.getString("trigger"));
        System.out.println("jobDetailJobDataMap:" + mergedJobDataMap.getString("trigger"));
        System.out.println("name:" + name);
    }
}
