package com.lincheng.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author lincheng5
 * @date 2021/11/1 23:19
 */
public class StudyMybatisPlus {

    /**
     * value:数据库主键字段名，如果是id，可以不用写
     * type:指定主键的类型，主键的值如何生成。idType.AUTO表示自动增长。
     *
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
