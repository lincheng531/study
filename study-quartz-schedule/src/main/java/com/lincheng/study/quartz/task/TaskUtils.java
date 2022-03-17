package com.lincheng.study.quartz.task;

import com.lincheng.study.quartz.utils.SpringUtils;
import com.lincheng.study.quartz.entity.TaskScheduleJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

@Slf4j
public class TaskUtils {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static void invokMethod(TaskScheduleJob scheduleJob) {

        try {//添加最大的异常捕获
            String springId = scheduleJob.getSpringId();
            Object object = null;
            Class clazz = null;

            //根据反射来进行
            if (StringUtils.isNotBlank(springId)) {
                object = SpringUtils.getBean(springId);
            }

            if (object == null && StringUtils.isNotBlank(scheduleJob.getBeanClass())) {
                String jobStr = "定时任务名称 = [" + scheduleJob.getJobName() + "]-在spring 中没有这个 springId, 通过 class type 获取中...";
                log.info(jobStr, scheduleJob.getBeanClass());
                try {
                    clazz = Class.forName(scheduleJob.getBeanClass());
                    object = SpringUtils.getBean(clazz);
                    if (object == null) {
                        jobStr = "定时任务名称 = [" + scheduleJob.getJobName() + "]-在spring 中没有获得 bean, 调用 spring 方法再次构建中...";
                        log.info(jobStr, scheduleJob.getBeanClass());
                        object = SpringUtils.getBeanByType(clazz);
                    }
                    if (StringUtils.isNotBlank(springId)) {
                        SpringUtils.setBean(springId, object);
                        log.info("spring bean 构建完成并加入到容器中 ", scheduleJob.getBeanClass());
                    }
                    log.info("定时任务 spring bean 构建成功! ", scheduleJob.getBeanClass());
                } catch (Exception e) {
                    log.error("定时任务 spring bean 构建失败了!!! ", scheduleJob.getBeanClass(), e);
                    return;
                }
            }

            clazz = object.getClass();
            Method method = null;
            try {
                method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
            } catch (NoSuchMethodException e) {
                String jobStr = "定时任务名称 = [" + scheduleJob.getJobName() + "] = 未启动成功，方法名设置错误！！！";
                log.error(jobStr, e);
            } catch (SecurityException e) {
                log.error("TaskUtils发生异常", e);
            }
            if (method != null) {
                try {
                    method.invoke(object);
                    log.info("定时任务名称 = [" + scheduleJob.getJobName() + "] = 启动成功");
                } catch (Exception e) {
                    log.error("定时任务名称 = [" + scheduleJob.getJobName() + "] = 启动失败了!!!", e);
                    return;
                }
            } else {
                String jobStr = "定时任务名称 = [" + scheduleJob.getJobName() + "] = 启动失败了!!!";
                log.error(jobStr, clazz.getName(), "not find method ");
            }

        } catch (Exception e) {//添加最大的异常捕获
            log.error("定时任务名称 = [" + scheduleJob.getJobName() + "] = 启动失败了!!!", e);
        }

    }
}
 

