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
@TableName("task_pro_num_statistics")
public class TaskProNumStatistics extends Model<TaskProNumStatistics> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 总记录数
     */
    @TableField("count_num")
    private Integer countNum;

    /**
     * 已产生数的和
     */
    @TableField("sum_num")
    private Integer sumNum;

    /**
     * 统计时间
     */
    @TableField("statistics_time")
    private LocalDateTime statisticsTime;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
