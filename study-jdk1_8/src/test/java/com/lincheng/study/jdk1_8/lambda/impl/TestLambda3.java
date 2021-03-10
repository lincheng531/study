package com.lincheng.study.jdk1_8.lambda.impl;

import com.lincheng.study.jdk1_8.lambda.MyFun3;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内部的内置四大核心接口
 *
 * 函数式接口	    参数类型	返回类型	用途
 *
 * Consumer
 * 消费型接口	    T	        void	    对类型为T的对象应用操作：void accept(T t)
 *
 * Supplier
 * 提供型接口	    无	        T	        返回类型为T的对象：T get()
 *
 * Function<T, R>
 * 函数型接口	    T	        R	        对类型为T的对象应用操作，并返回结果为R类型的对象：R apply(T t)
 *
 * Predicate
 * 断言型接口	    T	        boolean	    确定类型为T的对象是否满足某约束，并返回boolean值：boolean test(T t)
 *
 *
 * 其它接口
 * 函数式接口                                参数类型        返回类型     用途
 *
 * BiFunction<T, U, R>                      T，U             R            对类型为T, U参数应用操作，返回R类型的结果。包含方法为R apply(T t, U u);
 *
 * UnaryOperator<T>(Function子接口)         T               T            对类型为T的对象进行一元运算，并返回T类型的结果。包含方法为T apply(T t);
 *
 * BinaryOperator<T>(BiFunction子接口)      T, T            T            对类型为T的对象进行二元运算，并返回T类型的结果。包含方法为T apply(T t1, T t2) ;
 *
 * BiConsumer<T, U>                         T, U            void         对类型为T，U参数应用操作。包含方法为 void accept(T t, U u)
 *
 * ToIntFunction<T>                         T               int          分别计算int、long 、double、值的函数
 * ToLongFunction<T>                                        long
 * ToDoubleFunction<T>                                      double
 *
 * IntFunct ion<R>                          int             R            参数分别为int、long、double类型的函数
 * LongFunction<R>                          long
 * Doubl eFunction<R>                       double
 *
 */
public class TestLambda3 {

    /**
     * 消费型接口
     */
    @Test
    public void test1(){
        //Consumer
        Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
        //test
        consumer.accept(100);

    }



    /**
     * 提供型接口
     */
    @Test
    public void test2() {
        produceRandomArray(10, () -> new Random().nextInt(10));
    }

    private void produceRandomArray(Integer count, Supplier<Integer> sup) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numList.add(sup.get());
        }
        numList.forEach(System.out::println);
    }


    /**
     * 函数型接口
     */
    @Test
    public void test3() {
        String string = strHandler("\t\t\t测试函数式接口", (str) -> str.trim());
        System.out.println(string);

        String string1 = strHandler("\t\t\t测试函数式接口asdfsfrrqwerqwr", (str) -> str.toUpperCase());
        System.out.println(string1);

        String string2 = strHandler("\t\t\t测试函数式接口", (str) -> str.substring(2,5));
        System.out.println(string2);

    }

    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    /**
     * 断言型接口
     */
    @Test
    public void test4() {
        List<String> list = filterStr(Arrays.asList("1234","1","123"), s -> s.length() > 3);
        list.forEach(System.out::println);
    }


    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List strList = new ArrayList();
        for (String string : list) {
            if (predicate.test(string)){
                strList.add(string);
            }
        }
        return strList;
    }


















}
