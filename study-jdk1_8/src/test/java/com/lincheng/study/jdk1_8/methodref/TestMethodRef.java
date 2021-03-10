package com.lincheng.study.jdk1_8.methodref;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * 方法引用:若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用”
 *          (可以理解为方法引用是Lambda表达式的另外一种表现形式)
 *
 * 主要有三种语法格式:
 *      对象::实例方法名
 *      类::静态方法名
 *      类: :实例方法名
 */
public class TestMethodRef {

    @Test
    public void test1(){

        Consumer<String> consumer1 = x -> System.out.println(x);

        PrintStream printStream = System.out;
        Consumer<String> consumer2 = printStream::println;

        Consumer<String> consumer3 = System.out::println;

        consumer1.accept("1");
        consumer2.accept("2");
        consumer3.accept("3");

    }
}
