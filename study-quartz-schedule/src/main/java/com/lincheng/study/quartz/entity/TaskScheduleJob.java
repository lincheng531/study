package com.lincheng.study.quartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author linCheng
 * @since 2022-03-17
 */
@Getter
@Setter
@TableName("task_schedule_job")
public class TaskScheduleJob extends Model<TaskScheduleJob> {

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    public static final String CONCURRENT_IS = "1";
    public static final String CONCURRENT_NOT = "0";

    private static final long serialVersionUID = 1L;

    @TableId(value = "job_id", type = IdType.AUTO)
    private Long jobId;

    @TableField("create_time")
    private Timestamp createTime;

    @TableField("update_time")
    private Timestamp updateTime;

    /**
     * 任务类名
     */
    @TableField("job_name")
    private String jobName;

    /**
     * 任务组名和job_name保持一致即可
     */
    @TableField("job_group")
    private String jobGroup;

    /**
     * 定时任务是否生效0失效1生效
     */
    @TableField("job_status")
    private String jobStatus;

    /**
     * 定时任务cron表达式，推荐使用6域
     */
    @TableField("cron_expression")
    private String cronExpression;

    /**
     * 定时任务描述
     */
    @TableField("description")
    private String description;

    /**
     * 定时任务类名全路径
     */
    @TableField("bean_class")
    private String beanClass;

    /**
     * 1
     */
    @TableField("is_concurrent")
    private String isConcurrent;

    /**
     * 注册的Bean，所以与类名保持一致，首字母小写
     */
    @TableField("spring_id")
    private String springId;

    /**
     * 定时任务的方法名
     */
    @TableField("method_name")
    private String methodName;


    @Override
    public Serializable pkVal() {
        return this.jobId;
    }

}
