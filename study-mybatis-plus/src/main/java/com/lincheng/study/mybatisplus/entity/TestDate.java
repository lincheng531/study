package com.lincheng.study.mybatisplus.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 测试时间
 * </p>
 *
 * @author linCheng
 * @since 2021-12-08
 */
@Getter
@Setter
@TableName("c_test_date")
public class TestDate extends Model<TestDate> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 数据库字段类型date
     */
    @TableField("insert_date")
    private LocalDate insertDate;

    /**
     * 数据库字段类型datetime
     */
    @TableField("update_date")
    private Timestamp updateDate;

    @TableField("delete_date")
    private LocalDateTime deleteDate;

    @TableField("select_date")
    private LocalDate selectDate;

    @TableField("test_date")
    private Timestamp testDate;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
