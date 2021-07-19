package com.lincheng.study.basejava.domain;

/**
 * @author linCheng
 * @date 2021/7/19 18:31
 */
public class PersonVO {

    private String name;

    private Integer age;

    public PersonVO() {

    }

    public PersonVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}
