package com.lincheng.study.jdk1_8.methodref;

import com.lincheng.study.jdk1_8.domain.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用:若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用”
 *          (可以理解为方法引用是Lambda表达式的另外一种表现形式)
 *
 * 主要有三种语法格式:
 *   ()
 *      对象 :: 实例方法名
 *      类  :: 静态方法名
 *      类  :: 实例方法名
 *
 *
 *  注意:
 *      1.Lambda体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 *      2.若Lambda参数列表中的第一参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName :: method
 *
 *
 *
 * 二、构造器引用
 * 格式：
 *      ClassName :: new
 *
 *  注意：需要调用的构造器的参数列表要与函数时接口中抽象方法的参数列表保持一致
 *
 *
 *
 * 三、数组引用
 * 格式：
 *      Type :: new;
 *
 */
public class TestMethodRef {

    /**
     *    对象 :: 实例方法名
     */
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
    @Test
    public void test2(){
        Employee employee = new Employee();
        Supplier<String> supplier1 = () -> employee.getName();
        String name = supplier1.get();
        System.out.println(name);

        Supplier<Integer> supplier2 = employee::getAge;
        Integer age = supplier2.get();
        System.out.println(age);
    }


    /**
     *  类::静态方法名
     */
    @Test
    public void test3(){
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator2 = Integer::compare;
    }

    /**
     *   类  :: 实例方法名
     */
    @Test
    public void test4(){
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("a","b"));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("c","c"));
    }

    /**
     *  构造器引用 ClassName::new
     */
    @Test
    public void test5() {
        Supplier<Employee> employeeSupplier1 = () -> new Employee();

        //构造器方法
        Supplier<Employee> employeeSupplier2 = Employee::new;
        employeeSupplier2.get();
        System.out.println(employeeSupplier2);
    }

    @Test
    public void test6() {
        Function<String,Employee> employeeFunction = (x) -> new Employee();

        Function<String,Employee> employeeFunction2 = Employee::new;
        Employee employee1 = employeeFunction2.apply("name");
        System.out.println(employee1);


        BiFunction<String,Integer,Employee> employeeBiFunction =  Employee::new;
        Employee employee2 = employeeBiFunction.apply("name",2);
        System.out.println(employee2);
    }


    /**
     *  数组引用
     */
    @Test
    public void test7() {
        Function<Integer, String[]> function1 = (x) -> new String[x];
        String[] strArr1 = function1.apply(10);
        System.out.println(Arrays.toString(strArr1));

        Function<Integer, String[]> function2 = String[]::new;
        String[] strArr2 = function2.apply(10);
        System.out.println(Arrays.toString(strArr2));

    }

}
