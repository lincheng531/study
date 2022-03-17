package com.lincheng.study.quartz.controller;

import com.lincheng.study.quartz.utils.SpringUtils;
import com.lincheng.study.quartz.entity.TaskScheduleJob;
import com.lincheng.study.quartz.service.ITaskScheduleJobService;
import com.lincheng.study.quartz.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Classname SchedulerController
 * @Date 2020/3/18 14:57
 * @Created by gangye
 */
@Slf4j
@Controller
@RequestMapping("/task")
public class SchedulerController {
    
    
    @Autowired
    private ITaskScheduleJobService schedulerService;

    @RequestMapping("taskList")
    public String taskList(HttpServletRequest request) {
        List<TaskScheduleJob> taskList = schedulerService.getAllTask();
        request.setAttribute("taskList", taskList);
        return "/task/taskList";
    }

    @RequestMapping("add")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public Response taskList(HttpServletRequest request, TaskScheduleJob scheduleJob) {
        Response response = Response.newResponse();
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());
        } catch (Exception e) {
            response.setCodeAndMessage(9999,"cron表达式有误，不能被解析！");
            return response;
        }
        Object obj = null;
        Class clazz = null;
        try {
            if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
                obj = SpringUtils.getBean(scheduleJob.getSpringId());
                if(obj != null){
                    response.setCodeAndMessage(9999,"SpringId 重复了，不能被解析, 添加失败！");
                    return response;
                }
            }else{
                response.setCodeAndMessage(9999,"SpringId 不能为空，添加失败！");
                return response;
            }
            clazz = Class.forName(scheduleJob.getBeanClass());
            obj = clazz.newInstance();
        } catch (Exception e) {
            log.error("Class 名称有误，不能被解析: ",e);
            response.setCodeAndMessage(9999," Class 名称有误，不能被解析！");
            return response;
        }

        if (obj == null) {
            response.setCodeAndMessage(9999,"未找到目标类！");
            return response;
        } else {
            Method method = null;
            try {
                method = clazz.getMethod(scheduleJob.getMethodName(), null);
            } catch (Exception e) {
                response.setCodeAndMessage(9999,"未找到目标类执行方法");
                return response;
            }
            if (method == null) {
                response.setCodeAndMessage(9999,"未找到目标方法！");
                return response;
            }
        }
        try {
            schedulerService.addTask(scheduleJob);
            Object beanByType = SpringUtils.getBeanByType(clazz);
            SpringUtils.setBean(scheduleJob.getSpringId(), beanByType);
        } catch (Exception e) {
            log.error("添加失败任务", e);
            response.setCodeAndMessage(9999,"保存失败，检查 name group 组合是否有重复！");
            return response;
        }
        response.OK();
        return response;
    }

    @RequestMapping("changeJobStatus")
    @ResponseBody
    public Response changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
        Response response = Response.newResponse();
        try {
            schedulerService.changeStatus(jobId, cmd);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            response.setCodeAndMessage(9999,"任务状态改变失败！");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.OK();
        return response;
    }

    @RequestMapping("updateCron")
    @ResponseBody
    public Response updateCron(HttpServletRequest request, Long jobId, String cron) {
        Response response = Response.newResponse();
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        } catch (Exception e) {
            response.setCodeAndMessage(9999,"cron表达式有误，不能被解析！");
            return response;
        }
        try {
            schedulerService.updateCron(jobId, cron);
        } catch (Exception e) {
            response.setCodeAndMessage(9999,"cron更新失败！");
            return response;
        }
        response.OK();
        return response;
    }

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public Response exception(Throwable e) {
        //	error()方法将会添加错误信息到response对象
        Response response = Response.newResponse().error(e);
        return response;
    }

}
