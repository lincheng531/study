package com.lincheng.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * @author lincheng5
 * @date 2021/11/3 21:31
 */
public class StudyMybatisPlusAr extends Model<StudyMybatisPlusAr> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String studyAr;
    private Date createTime;
    private String mobile;
    private Integer age;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudyAr() {
        return studyAr;
    }

    public void setStudyAr(String studyAr) {
        this.studyAr = studyAr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
