package com.lincheng.study.basejava.reflection;

import com.alibaba.fastjson.JSON;
import com.lincheng.study.basejava.domain.PersonVO;
import org.springframework.cache.annotation.CacheConfig;
import sun.awt.OSInfo;

import javax.xml.transform.Source;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author linCheng
 * @date 2021/7/19 18:33
 */
public class StudyReflection {



    public static void main(String[] args)throws Exception{
        testReflection();
        //testReflectionFunctionByField();
        //testReflectionFunctionByConstructor();
        //testReflectionFunctionByMethod();
        //testReflectionGetClassName();
    }



    /**
     * Class对象功能:
     *   获取功能:
     *      1.获取成员变业们
     *          Field[] getFields() //获取所有public修饰的成员变量
     *          Field getField(string name) //获取指定 public修饰的成员变量
     *          Field[] getDeclaredFields() //获取所有成员变量
     *          Field getDeclaredField(String name)//获取指定的成员变量
     *      2.获取构造方法们
     *          Constructor<?>[] getConstructors()
     *          ConstructorkT> getConstructor(类<?>... parameterTypes )
     *          Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     *          Constructor<?>[] getDeclaredConstructors()
     *      3.获取成员方法们:
     *          Method[] getMethods()
     *          Method getMethod(String name,类<?>... parameterTypes)
     *          Method[] getDeclaredMethods()
     *          Method getDeclaredMethod(String name,类<?>... parameterTypes )
     *
     *      4.获取类名
     *          String getName( )
     *
     *
     *
     **/
    private static void testReflectionFunctionByField()throws Exception {

        Class personVOClass = PersonVO.class;


        Field field = personVOClass.getField("sex");
        System.out.println(field);
        Field[] fields = personVOClass.getFields();
        System.out.println(JSON.toJSONString(fields));
        System.out.println("====================");
        //使用
        Field sex = personVOClass.getField("sex");
        PersonVO personVO = new PersonVO();
        //设置值
        sex.set(personVO,"男");
        //取值
        Object obj = sex.get(personVO);
        System.out.println(obj);
        System.out.println("====================");
        Field age = personVOClass.getDeclaredField("age");
        System.out.println(age);
        Field[] declaredFields = personVOClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        System.out.println("====================");
        //忽略访问权限修饰符的安全检查
        ///暴力反射
        age.setAccessible(true);
        age.set(personVO,16);
        Object obj2 = age.get(personVO);
        System.out.println(obj2);
    }

    private static void testReflectionFunctionByConstructor()throws Exception{

        Class personVOClass = PersonVO.class;
        System.out.println("==========有参构造器==========");
        Constructor constructor = personVOClass.getConstructor(String.class, Integer.class);
        Object person = constructor.newInstance("张三", 11);
        System.out.println(person);
        System.out.println("==========无参构造器1==========");
        Constructor constructor2 = personVOClass.getConstructor();
        Object person2 = constructor2.newInstance();
        System.out.println(person2);
        System.out.println("============无参构造器2========");
        Object person3 = personVOClass.newInstance();
        System.out.println(person3);

    }

    private static void testReflectionFunctionByMethod()throws Exception{
        Class personVOClass = PersonVO.class;
        System.out.println("====================");
        Method eat1 = personVOClass.getMethod("eat");
        PersonVO personVO = new PersonVO();
        eat1.invoke(personVO);
        System.out.println("====================");
        Method eat2 = personVOClass.getMethod("eat",String.class);
        eat2.invoke(personVO,"饺子");
        System.out.println("----------------------");
        Method[] methods = personVOClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }

    }

    private static void testReflectionGetClassName()throws Exception{
        Class personVOClass = PersonVO.class;
        //全类名
        String name = personVOClass.getName();
        System.out.println(name);
    }



    /*
     获取Class对象的方式:
     1. Class.forName("全类名"):将字节码文件加载进内存，返回Class对象（方法区）
        ：多用于配的文件，将类名定义在配文件中。读取文件，加载类
     2.类名.class 通过类名的属性class获取(堆，内存)
        ：多用于参数的传递
     3.对象.getClass(); getClass()方法在Object类中定义著。（实例对象）
        ：多用于对象的获取字节码的方式

     结论:
     同一个字节码文件(* .class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方 式获取的Class对象都是同一个。
     */
    private static void testReflection()throws Exception{
        //字节码
        Class aClass1 = Class.forName("com.lincheng.study.basejava.domain.PersonVO");
        System.out.println(aClass1);
        //内存
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
