package com.lincheng.study.basejava.domain;

/**
 * @author linCheng
 * @date 2021/7/19 18:31
 */
public class PersonVO {

    private String name;

    private Integer age;

    public String sex;

    public String sex1;
    public String a1;
    public String b1;
    public String sex2;
    public String a2;
    public String b2;
    public String sex3;
    public String a3;
    public String b3;

    public String getSex1() {
        return sex1;
    }

    public void setSex1(String sex1) {
        this.sex1 = sex1;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getSex3() {
        return sex3;
    }

    public void setSex3(String sex3) {
        this.sex3 = sex3;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3;
    }

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
