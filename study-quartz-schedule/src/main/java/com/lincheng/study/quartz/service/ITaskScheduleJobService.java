package com.lincheng.study.quartz.service;

import com.lincheng.study.quartz.entity.TaskScheduleJob;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linCheng
 * @since 2022-03-17
 */
public interface ITaskScheduleJobService extends IService<TaskScheduleJob> {

    /**
     * 从数据库中取 区别于getAllJob
     *
     * @return
     */
    List<TaskScheduleJob> getAllTask();

    /**
     * 添加到数据库中 区别于addJob
     */
    void addTask(TaskScheduleJob job) throws Exception;

    /**
     * 从数据库中查询job
     */
    TaskScheduleJob getTaskById(Long jobId);

    /**
     * 更改任务状态
     *
     * @throws Exception
     */
    void changeStatus(Long jobId, String cmd) throws Exception;

    /**
     * 更改任务 cron表达式
     *
     * @throws Exception
     */
    void updateCron(Long jobId, String cron) throws Exception;

    /**
     * 添加任务
     *
     * @param job
     * @throws Exception
     */
    void addJob(TaskScheduleJob job) throws Exception;

    /**
     * 获取所有计划中的任务列表
     *
     * @return
     * @throws Exception
     */
    List<TaskScheduleJob> getAllJob() throws Exception;

    /**
     * 所有正在运行的job
     *
     * @return
     * @throws Exception
     */
    List<TaskScheduleJob> getRunningJob() throws Exception;

    /**
     * 暂停一个job
     *
     * @param scheduleJob
     * @throws Exception
     */
    void pauseJob(TaskScheduleJob scheduleJob) throws Exception;

    /**
     * 恢复一个job
     *
     * @param scheduleJob
     * @throws Exception
     */
    void resumeJob(TaskScheduleJob scheduleJob) throws Exception;

    /**
     * 删除一个job
     *
     * @param scheduleJob
     * @throws Exception
     */
    void deleteJob(TaskScheduleJob scheduleJob) throws Exception;

    /**
     * 立即执行job
     *
     * @param scheduleJob
     * @throws Exception
     */
    void runAJobNow(TaskScheduleJob scheduleJob) throws Exception;

    /**
     * 更新job时间表达式
     *
     * @param scheduleJob
     * @throws Exception
     */
    void updateJobCron(TaskScheduleJob scheduleJob) throws Exception;
    
}
