package com.lincheng.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author lincheng5
 * @date 2021/11/1 23:19
 */
//定义实体类,默认的表名和实体类同名; 如果不一致,在实体类定义上面使用
@TableName(value = "study_mybatis_plus")
public class StudyMybatisPlus {

    /**
     * value:数据库主键字段名，如果是id，可以不用写
     * type:指定主键的类型，主键的值如何生成。idType.AUTO表示自动增长。
     *
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    /**
     * 指定属性和列名的对应关系。
     * 默认属性名 等于 数据库字段名
     */
    @TableField(value = "name")
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
