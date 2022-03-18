package com.lincheng.study.quartz.bootquartz;

import com.lincheng.study.common.utils.DateUtils;
import org.quartz.*;
import org.quartz.Calendar;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.*;

/**
 * @author lincheng5
 * @date 2022/3/16 21:59
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class QuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Thread.sleep(3000);
            System.out.println(jobExecutionContext.getScheduler().getSchedulerInstanceId());
            System.out.println(jobExecutionContext.getJobDetail().getKey().getName());
            System.out.println(DateUtils.dateToString(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
