package com.lincheng.study.quartz.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.util.concurrent.Executors;

/**
 * @author lincheng5
 * @date 2022/3/16 23:35
 */
@Slf4j
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Resource
    private SyncServiceImpl sync;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //当然了，这里设置的线程池是corePoolSize也是很关键了，自己根据业务需求设定
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));

        /**为什么这么说呢？
         假设你有4个任务需要每隔1秒执行，而其中三个都是比较耗时的操作可能需要10多秒，而你上面的语句是这样写的：
         taskRegistrar.setScheduler(Executors.newScheduledThreadPool(3));
         那么仍然可能导致最后一个任务被阻塞不能定时执行
         **/

        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> sync.sync(),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = "0 0/15 * * * ?";
                    log.info("用户执行负荷控制信息同步_corn:{}", cron);
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
