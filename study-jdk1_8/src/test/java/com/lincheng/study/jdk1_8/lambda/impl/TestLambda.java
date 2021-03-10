package com.lincheng.study.jdk1_8.lambda.impl;

import com.lincheng.study.jdk1_8.StudyJdk18Application;
import com.lincheng.study.jdk1_8.domain.Employee;
import com.lincheng.study.jdk1_8.lambda.MyFun;
import com.lincheng.study.jdk1_8.lambda.MyFun2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyJdk18Application.class)
/**
 *一、Lambda 表达式的基础语法: Java8中引入了一个新的操作符"->”该操作符称为箭头操作符或Lambda操作符
 *      箭头操作符将Lambda表达式拆分成两部分:
 *      左侧: Lambda表达式的参数列表
 *      右侧: Lambda表达式中所需执行的功能，即Lambda体
 *
 * 语法格式一: 无参数，无返因值
 *       () ->   System.out.println();
 *
 * 语法格式二:有一个参数，并且无返回值
 *      (x) ->  System.out.println(x)
 *
 * 语法格式三:若只有一个参数。小括号可以省略不写
 *      x -> System.out.print1n(x)
 *
 * 语法格式四:有两个以上的参数，有返回值，并且Lambda体中有多条语句!
 *          Comparator<Integer> com = (x, y) -> {
 *              System. out. println("函数式接口");
 *              return Integer . compare(x, y);
 *          };
 *
 * 语法格式五:若Lambda体中只有一条语句，return 和大括号都可以省略不写
 *      Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六: Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 *      (Integer Xz Integer y) -> Integer.compare(x, y);
 *
 * 函数式接口：
 *  接口中只有一个抽象方法的接口 @FunctionalIterface
 *
 */
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
    }


    @Test
    public void test2() {
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        TreeSet<Integer> integers = new TreeSet<>(com2);
    }

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三",18,1.00),
            new Employee("李四",85,2.00),
            new Employee("王五",58,3.00),
            new Employee("赵六",11,4.00),
            new Employee("田七",35,5.00)
    );




    /**
     * @author: linCheng
     * @description:  函数式接口
     * @date: 2021/3/10 14:16
     * @param null
     * @return
     */
    @Test
    public void test3() {
        Integer operation = operation(100, x -> x / x);
        System.out.println(operation);

        Integer operation1 = operation(1, 2, (a, b) -> a + b);
        System.out.println(operation1);
    }

    public Integer operation(Integer num, MyFun myFun){
        return myFun.getValue(num);
    }

    public Integer operation(Integer a, Integer b,MyFun2 myFun){
        return myFun.count(a,b);
    }



}
