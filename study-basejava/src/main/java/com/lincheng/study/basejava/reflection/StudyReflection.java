package com.lincheng.study.basejava.reflection;

import com.lincheng.study.basejava.domain.PersonVO;
import org.springframework.cache.annotation.CacheConfig;

import java.util.function.Predicate;

/**
 * @author linCheng
 * @date 2021/7/19 18:33
 */
public class StudyReflection {


    /**
     获取Class对象的方式:
     1. Class.forNlame("全类名"):将字节码文件加载进内存，返回Class对象
            ：多用于配的文件，将类名定义在配文件中。读取文件，加载类
     2.类名.class 通过类名的属性class获取
            ：多用于参数的传递
     3.对象.getClass(); getClass()方法在Object类中定义著。
            ：多用于对象的获取字节码的方式
     结论:
     同一个字节码文件(* .class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方 式获取的Class对象都是同一个。
     */

    public static void main(String[] args)throws Exception{
        testReflection();
    }


    private static void testReflection()throws Exception{

        Class aClass1 = Class.forName("com.lincheng.study.basejava.domain.PersonVO");
        System.out.println(aClass1);

        Class aClass2 = PersonVO.class;
        System.out.println(aClass2);

        PersonVO personVO = new PersonVO();
        Class aClass3 = personVO.getClass();
        System.out.println(aClass3);

        //比较
        System.out.println(aClass1 == aClass2);
        System.out.println(aClass2 == aClass3);
        System.out.println(aClass1 == aClass3);


    }
}
