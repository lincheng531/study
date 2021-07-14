package com.lincheng.study.basejava.thread;

import java.sql.SQLOutput;

/**
 * @author linCheng
 * @date 2021/7/14 10:37
 */
public class StudyVolatile {



    public static void main(String[] args) {
        testVolatileVisible();

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

    public void add(){
        this.num = 60;
    }
}