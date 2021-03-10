package com.lincheng.study.jdk1_8.lambda.impl;

import com.lincheng.study.jdk1_8.domain.Employee;
import com.lincheng.study.jdk1_8.lambda.MyFun3;
import com.lincheng.study.jdk1_8.lambda.MyFun4;
import org.junit.Test;

import java.util.*;

public class TestLambda2 {

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三",18,1.00),
            new Employee("李四",85,2.00),
            new Employee("王五",58,3.00),
            new Employee("赵六",11,4.00),
            new Employee("田七",35,5.00)
    );

    @Test
    public void test1() {
        Collections.sort(employeeList,(e1,e2) -> {
            if (e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
    }

    @Test
    public void test4() {
        String string = strHandler("\t\t\t测试函数式接口", (str) -> str.trim());
        System.out.println(string);

        String string1 = strHandler("\t\t\t测试函数式接口asdfsfrrqwerqwr", (str) -> str.toUpperCase());
        System.out.println(string1);

        String string2 = strHandler("\t\t\t测试函数式接口", (str) -> str.substring(2,5));
        System.out.println(string2);

    }

    public String strHandler(String str, MyFun3 myFun3){
        return myFun3.getValue(str);
    }


    @Test
    public void test5() {

        sun(1L,2L , (x,y) -> x + y);

        sun(1L,2L , (x,y) -> x * y);

    }



    public void sun(Long integer1,Long integer2, MyFun4<Long,Long> myFun4){
        System.out.println(myFun4.getValue(integer1,integer2));
    }


}
