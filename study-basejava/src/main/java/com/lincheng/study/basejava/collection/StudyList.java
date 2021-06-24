package com.lincheng.study.basejava.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author lincheng5
 * @date 2021/6/24 22:51
 */
public class StudyList {

    /**
     * @Description: 学习list
     * @Method: main
     * @Param: [args]
     * @Return: void
     * @Author: lincheng5
     * @Date: 2021/6/24 23:00
     **/
    public static void main(String[] args) {

        /*
         *  ArrayList（线程不安全；数组对象组成）
         *
         *  1、底层维护了一个Object类型的数组（transinet Object elementDate）
         *
         *  2、ArrayList，如果使用用无参构造器，则初始的elementDate容量为0（空数组 private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}），
         *      第一次添加，则容量为10
         *      如果需求再次扩容，则扩容为element*1.5倍
         *
         *  3、如果使用有参构造器，则容量elementDate为指定的大小，
         *      如果需求再次扩容，则扩容为element*1.5倍
         *
         *  4、arrayList是由数组来实现数据的存储的;
         *     用transient（瞬间）来修饰时，表示该属性不会被序列化
         *
         *
         *  Vector(线程安全；数组对象组成)
         *
         *  1、vector，如果使用用无参构造器，则初始的elementDate容量为 10，
         *      如果需求再次扩容，则扩容为elementDate*2倍
         *
         *  2、如果使用有参构造器，则容量elementDate为指定的大小，
         *      如果需求再次扩容，则扩容为elementDate*2倍
         *
         *
         *  LinkedList(线程不安全；双向链表+双端队列)
         *
         *
         * ArrayList和LinkedList的比较
         *************|*************|*******************|*****************|
         *            |    底层结构  |    增删效率        |     改查        |
         *  ArrayList |    可变数组  |   慢：数组扩容     |    快：索引      |
         * LinkedList |    双向链表  |   快：通过链表追加  |   慢： 链表遍历  |
         *************|*************|*******************|*****************|
         *
         *
         */
    }
}
