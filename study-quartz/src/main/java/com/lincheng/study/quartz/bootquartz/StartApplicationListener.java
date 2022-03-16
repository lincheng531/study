package com.lincheng.study.quartz.bootquartz;

import com.google.common.util.concurrent.AbstractScheduledService;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author lincheng5
 * @date 2022/3/16 22:15
 */
@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private Scheduler scheduler;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger1","group1");
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger == null){
                trigger =  TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                        .startNow()
                        .build();

                JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                        .withIdentity("trigger1","group1")
                        .build();

                scheduler.scheduleJob(jobDetail,trigger);
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
