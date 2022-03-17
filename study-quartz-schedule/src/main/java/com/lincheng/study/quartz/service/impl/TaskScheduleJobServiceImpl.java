package com.lincheng.study.quartz.service.impl;

import com.lincheng.study.common.utils.DateUtils;
import com.lincheng.study.quartz.entity.TaskScheduleJob;
import com.lincheng.study.quartz.mapper.TaskScheduleJobMapper;
import com.lincheng.study.quartz.service.ITaskScheduleJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lincheng.study.quartz.task.QuartzJobFactory;
import com.lincheng.study.quartz.task.QuartzJobFactoryDisallowConcurrentExecution;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linCheng
 * @since 2022-03-17
 */
@Slf4j
@Service
public class TaskScheduleJobServiceImpl extends ServiceImpl<TaskScheduleJobMapper, TaskScheduleJob> implements ITaskScheduleJobService {

    @Resource
    private SchedulerFactoryBean schedulerFactoryBean;

    @Resource
    private TaskScheduleJobMapper taskScheduleJobMapper;

    /**
     * 从数据库中取 区别于getAllJob
     *
     * @return
     */
    public List<TaskScheduleJob> getAllTask() {
        return taskScheduleJobMapper.selectByMap(new HashMap<>());
    }

    /**
     * 添加到数据库中 区别于addJob
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addTask(TaskScheduleJob job) throws Exception {
        job.setCreateTime(DateUtils.dateToTimestamp(new Date()));
        taskScheduleJobMapper.insert(job);
        addJob(job);
    }

    /**
     * 从数据库中查询job
     */
    public TaskScheduleJob getTaskById(Long jobId) {
        return taskScheduleJobMapper.selectById(jobId);
    }

    /**
     * 更改任务状态
     *
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeStatus(Long jobId, String cmd) throws Exception {
        TaskScheduleJob job = getTaskById(jobId);
        if (job == null) {
            return;
        }
        if ("stop".equals(cmd)) {
            deleteJob(job);
            job.setJobStatus(TaskScheduleJob.STATUS_NOT_RUNNING);
        } else if ("start".equals(cmd)) {
            job.setJobStatus(TaskScheduleJob.STATUS_RUNNING);
            addJob(job);
        }
        taskScheduleJobMapper.updateById(job);
    }

    /**
     * 更改任务 cron表达式
     *
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCron(Long jobId, String cron) throws Exception {
        TaskScheduleJob job = getTaskById(jobId);
        if (job == null) {
            return;
        }
        job.setCronExpression(cron);
        if (TaskScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            updateJobCron(job);
        }
        taskScheduleJobMapper.updateById(job);

    }

    /**
     * 添加任务
     *
     * @param job
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addJob(TaskScheduleJob job) throws Exception {
        if (job == null || !TaskScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        log.info(scheduler + ".......................................................................................add");
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        // 不存在，创建一个
        if (null == trigger) {
            Class clazz = TaskScheduleJob.CONCURRENT_IS.equals(job.getIsConcurrent()) ? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;

            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();

            jobDetail.getJobDataMap().put("TaskScheduleJob", job);

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
        } else {
            // Trigger已存在，那么更新相应的定时设置
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    @PostConstruct
    public void init() throws Exception {

        log.info("实例化List<TaskScheduleJob>,从数据库读取....{}",this);

        // 这里获取任务信息数据
        List<TaskScheduleJob> jobList =  taskScheduleJobMapper.selectByMap(new HashMap<>());


        for (TaskScheduleJob job : jobList) {
            addJob(job);
        }
    }

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     * @throws Exception
     */
    public List<TaskScheduleJob> getAllJob() throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<TaskScheduleJob> jobList = new ArrayList<TaskScheduleJob>();
        for (JobKey jobKey : jobKeys) {
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            for (Trigger trigger : triggers) {
                TaskScheduleJob job = new TaskScheduleJob();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setDescription("触发器:" + trigger.getKey());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setJobStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
                jobList.add(job);
            }
        }
        return jobList;
    }

    /**
     * 所有正在运行的job
     *
     * @return
     * @throws Exception
     */
    public List<TaskScheduleJob> getRunningJob() throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<TaskScheduleJob> jobList = new ArrayList<TaskScheduleJob>(executingJobs.size());
        for (JobExecutionContext executingJob : executingJobs) {
            TaskScheduleJob job = new TaskScheduleJob();
            JobDetail jobDetail = executingJob.getJobDetail();
            JobKey jobKey = jobDetail.getKey();
            Trigger trigger = executingJob.getTrigger();
            job.setJobName(jobKey.getName());
            job.setJobGroup(jobKey.getGroup());
            job.setDescription("触发器:" + trigger.getKey());
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            if (trigger instanceof CronTrigger) {
                CronTrigger cronTrigger = (CronTrigger) trigger;
                String cronExpression = cronTrigger.getCronExpression();
                job.setCronExpression(cronExpression);
            }
            jobList.add(job);
        }
        return jobList;
    }

    /**
     * 暂停一个job
     *
     * @param TaskScheduleJob
     * @throws Exception
     */
    public void pauseJob(TaskScheduleJob TaskScheduleJob) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(TaskScheduleJob.getJobName(), TaskScheduleJob.getJobGroup());
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复一个job
     *
     * @param TaskScheduleJob
     * @throws Exception
     */
    public void resumeJob(TaskScheduleJob TaskScheduleJob) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(TaskScheduleJob.getJobName(), TaskScheduleJob.getJobGroup());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除一个job
     *
     * @param TaskScheduleJob
     * @throws Exception
     */
    public void deleteJob(TaskScheduleJob TaskScheduleJob) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(TaskScheduleJob.getJobName(), TaskScheduleJob.getJobGroup());
        scheduler.deleteJob(jobKey);

    }

    /**
     * 立即执行job
     *
     * @param TaskScheduleJob
     * @throws Exception
     */
    public void runAJobNow(TaskScheduleJob TaskScheduleJob) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(TaskScheduleJob.getJobName(), TaskScheduleJob.getJobGroup());
        scheduler.triggerJob(jobKey);
    }

    /**
     * 更新job时间表达式
     *
     * @param TaskScheduleJob
     * @throws Exception
     */
    public void updateJobCron(TaskScheduleJob TaskScheduleJob) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(TaskScheduleJob.getJobName(), TaskScheduleJob.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(TaskScheduleJob.getCronExpression());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }


}
