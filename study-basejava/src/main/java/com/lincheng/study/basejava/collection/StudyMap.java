package com.lincheng.study.basejava.collection;

/**
 * @author lincheng5
 * @date 2021/6/24 23:42
 */
public class StudyMap {

    public static void main(String[] args) {

        /*
         *  Map（线程不安全；数组对象组成）
         *
         *
         *
         *
         *  HashMap(线程不安全；数组+链表+红黑树)
         *      1、HashMap 的长度是2的幂次方(为了能让 HashMap存取高效，尽量较少碰撞，也就是要尽量把数据分配均匀)
         *
         *
         *  简单说明Hashtable的底层
         *  1、底层有数组Hashtable$Entry[] 初始化大小为11，扩容为2n+1
         *  2、临界值threshold 8 = 11*0.75
         *  3、扩容:按照自己的扩容机制来进行即可.
         *
         *  ConcurrentHashMap(线程安全)
         *      1、jdk1.8舍弃分段锁
         *          1)加入多个分段锁浪费内存空间。
                    2)生产环境中， map 在放入时竞争同一个锁的概率非常小，分段锁反而会造成更新等操作的长时间等待。
                    3)为了提高 GC的效率
         *
         */
    }
}
