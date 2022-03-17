package com.lincheng.study.quartz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
@TableName("task_product_num")
public class TaskProductNum extends Model<TaskProductNum> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    @TableField("bat_no")
    private String batNo;

    /**
     * 产生的随机数字
     */
    @TableField("pro_num")
    private Integer proNum;

    /**
     * 产生数字的时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
