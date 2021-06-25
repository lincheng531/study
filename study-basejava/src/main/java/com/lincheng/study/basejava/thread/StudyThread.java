package com.lincheng.study.basejava.thread;


import org.bouncycastle.util.test.TestFailedException;

/**
 * @author linCheng
 * @date 2021/6/25 14:05
 *
 * 一个进程能有多个线程
 * 并行：单核CPU（切换进行执行）
 * 并发：多核CPU（同时进行执行）
 *
 *
 */
@SuppressWarnings({"all"})
public class StudyThread {


    public static void main(String[] args) {

        //getavailableProcessors();

        //buildThread();

        buildRunnable();
    }

    public static void buildRunnable(){
        TestRunnable testRunnable = new TestRunnable();
        Thread thread = new Thread(testRunnable);
        thread.start();
    }

    /**
     * 实现Runnable
     */
    static class TestRunnable implements Runnable{
        int sun = 0;
        @Override
        public void run() {
            while (true) {
                try {
                    sun ++;
                    Thread.sleep(1000);
                    System.out.println("测试线程:" + sun + "线程名称:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(sun == 5){
                    break;
                }
            }
        }
    }


    /**
     * 查询当前电脑CPU数
     */
    public static void getavailableProcessors(){
        Runtime runtime= Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }


    public static void buildThread(){
        /**
         * 创建线程的两种方式
         *      1、继承Thread类，重写run方法。
         *      2、实现Runnable接口，重写run方法。
         *
         * 当前主方法为主线程，而cal.start()为子线程。
         *
         *
         * 原码解读：
         *       (1)
         *       public synchronized void start() {
         *           start0();
         *       }
         *       (2)
         *       //start0()是本地方法，由JVM调用，底层由c/c++实现
         *       private native void start0();
         *
         *      总结start调用了start0方法后，该线程并不一定会马上执行，只是将线程变成了可以运行的状态，具体什么时候执行，取决于CPU，由CPU统一调度
         *
         *
         *
         */
        cal cal = new cal();
        //如果直接调用cal.run(),不会启动子线程（可以理解为，run()就是一个普通的方法），这样就会先执行完run()方法，才会执行下面的方法
        cal.start();
        //当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行

        System.out.println("主线程继续执行：" + Thread.currentThread().getName());
        for (int i = 0 ;i < 10 ;i++){
            System.out.println("主线程：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 当一个类继承了thread类，该类可以当做线程来使用
     *
     * 其实Thread也是实现了Runnable接口。
     */
    static class cal extends Thread{
        int sun = 0;
        @Override
        public void run() {
            //重写run方法，写上自己的业务逻辑
            while (true) {
                try {
                    sun ++;
                    Thread.sleep(1000);
                    System.out.println("测试线程:" + sun + "线程名称:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(sun == 5){
                    break;
                }
            }
        }
    }






}
