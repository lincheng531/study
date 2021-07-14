package com.lincheng.study.basejava.thread;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author linCheng
 * @date 2021/7/14 10:37
 */
public class StudyVolatile {



    public static void main(String[] args) {
        //testVolatileVisible();
        //testVolatileAtomic();
        testVolatileAtomic2();
    }

    /**
     * 可见性
     *
     * 验证volatile不保证原子性
     *  2.1原子性指的是什么意思?
     *      不可分割，完整性，也即菜个线程正在做某个具体业务时，中间不可以鼓加赛或者被分割。需要整体完整
     *      要么同时成功，要么同时失败。
     *
     */
    public static void testVolatileAtomic(){
        MyDate myDate = new MyDate();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myDate.addPlus();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待上:面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少?
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + myDate.num);
    }


    public static void testVolatileAtomic2(){
        MyDate myDate = new MyDate();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myDate.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }
        //需要等待上:面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少?
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + myDate.atomicInteger);
    }



    /**
     * 可见性
     */
    public static void testVolatileVisible(){

        MyDate myDate = new MyDate();
        new Thread(()->{
            try {
                Thread.sleep(3000);
                myDate.add();
                System.out.println(Thread.currentThread().getName() + "\t" + myDate.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程A").start();

        while (myDate.num == 0) {
            System.out.println("测试可见性");
        }
        System.out.println(Thread.currentThread().getName() + "\t" + myDate.num);
    }



}


class MyDate{

    volatile int num = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void add(){
        this.num = 60;
    }

    public void addPlus(){
        num ++;
    }

    public void addPlusPlus() {
        atomicInteger.getAndIncrement();
    }

}

