package com.lincheng.study.quartz.scheduled;

import com.lincheng.study.common.utils.DateUtils;
import com.lincheng.study.common.utils.ThreadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;

/**
 * @author lincheng5
 * @date 2022/3/16 23:25
 */
@EnableScheduling
@Configuration
public class ScheduledTest {

    @Scheduled(cron = "0/5 * * * * ?")
    public void pushDataScheduled() {
        ThreadUtils.runInNewThreadByExecutors(() -> {
            System.out.println("pushDataScheduled: " + DateUtils.dateToString(new Date()));
        });
    }


    //@Scheduled(cron = "0/10 * * * * ?")
    public void pushDataScheduledTest() {
        System.out.println(DateUtils.dateToString(new Date()));
    }

}
