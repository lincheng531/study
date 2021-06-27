package com.lincheng.study.basejava.thread;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author lincheng5
 * @date 2021/6/27 22:13
 */
public class StudyThreadSynchronized {


    /**
     *一、线程同步机制
     *
     *  1.在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技
     *      术，保证数据在任何同一时刻，最多有一个线程访问，以保证数据的完整性。
     *
     *  2.也可以这里理解: 线程同步，即当有一个线程在对内存进行操作时，其他线程都不
     *      可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地
     *
     * 二、同步具体方法-Synchronized
     * 1.同步代码块synchronized (对象) { //得到对象的锁，才能操作同步代码
     *      //需要被同步代码;
     * }
     * 2. synchronized还可以放在方法声明中， 表示整个方法为同步方法
     * public synchronized void m (String name){
     *      //需要被同步的代码
     * }
     *
     * 三、互斥锁。
     *  基本介绍
     * 1. Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
     * 2.每个对象都对应于一一个可称为“互斥锁”的标记，这个标记用来保证在任一-时刻，只能有一个线程访问该对象。
     * 3.关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时，表明该对象在任一时刻只能由- 个线程访问
     * 4.同步的局限性:导致程序的执行效率要降低
     * 5.同步方法(非静态的)的锁可以是this,也可以是其他对象(要求是同一个对象)
     * 6.同步方法(静态的)的锁为当前类本身。类
     *
     **/
    public static void main(String[] args) {
        TestThreadSynchronized();
    }

    public static void TestThreadSynchronized(){
        sellTicket sellTicket = new sellTicket();
        Thread thread1 = new Thread(sellTicket);
        thread1.setName("窗口一");
        thread1.start();
        Thread thread2 = new Thread(sellTicket);
        thread2.setName("窗口二");
        thread2.start();
        Thread thread3 = new Thread(sellTicket);
        thread3.setName("窗口三");
        thread3.start();

    }


    static class sellTicket implements Runnable{

        private int ticketNum = 100;
        private boolean loop = true;

        //两种方式
        public /*synchronized*/ void sell(){
            synchronized (this) {
                if (ticketNum <= 0) {
                    loop = false;
                    System.out.println("售票结束----");
                    return;
                }


                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余票数=" + (--ticketNum));
            }
        }

        @Override
        public void run() {

            while (loop){
                sell();
            }

        }
    }

}
