package com.lincheng.study.basejava.domain;

/**
 * @author linCheng
 * @date 2021/7/19 18:31
 */
public class PersonVO {

    private String name;

    private Integer age;

    public String sex;

   public PersonVO() {

    }

    public PersonVO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonVO(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void eat(){
        System.out.println("eat......");
    }

    public void eat(String value){
        System.out.println("eat......" + value);
    }

}
