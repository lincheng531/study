package com.lincheng.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author lincheng5
 * @date 2021/11/3 21:31
 */
@Data
public class StudyMybatisPlusAr extends Model<StudyMybatisPlusAr> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String studyAr;
    private Date createTime;
    private String mobile;
    private Integer age;
    private Integer state;

}
