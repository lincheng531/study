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

        //buildRunnable();

        //testThreadMethod();

        testThreadMethod2();

    }

    public static void buildRunnable() {
        TestRunnable testRunnable = new TestRunnable();
        //底层使用了设计模式[代理模式]
        Thread thread = new Thread(testRunnable);
        thread.start();
    }

    /**
     * 实现Runnable
     */
    static class TestRunnable implements Runnable {
        int sun = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    sun++;
                    Thread.sleep(1000);
                    System.out.println("测试线程:" + sun + "线程名称:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (sun == 5) {
                    break;
                }
            }
        }
    }


    /**
     * 查询当前电脑CPU数
     */
    public static void getavailableProcessors() {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }


    public static void buildThread() {
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
        for (int i = 0; i < 10; i++) {
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
     * <p>
     * 其实Thread也是实现了Runnable接口。
     */
    static class cal extends Thread {
        int sun = 0;

        @Override
        public void run() {
            //重写run方法，写上自己的业务逻辑
            while (true) {
                try {
                    sun++;
                    Thread.sleep(1000);
                    System.out.println("测试线程:" + sun + "线程名称:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (sun == 5) {
                    break;
                }
            }
        }
    }


    /**
     * 1. setName //设置线程名称，使之与参数name相同
     * 2. getName //返回该线程的名称
     * 3. start //使该线程开始执行; Java虚拟机底层调用该线程的start0方法
     * 4. run  //调用线程对象run方法;
     * 5. setPriority //更改线程的优先级
     * 6. getPriority //获取线程的优先级
     * 7. sleep //在指定的毫秒数内让当前正在执行的线程休眠(暂停执行)(休眠当前线程)
     * 8. interrupt  //中断线程，但并没有真正的结束线程。所以一般用于中断正在休眠线程
     **/
    public static void testThreadMethod() {
        threadMethod threadMethod = new threadMethod();
        threadMethod.setName("设置线程名称");
        threadMethod.setPriority(Thread.MIN_PRIORITY);
        threadMethod.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //提前结束子线程的休眠，让子线程提前运行
        threadMethod.interrupt();
    }



    static class threadMethod extends Thread {
        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < 3; i++) {
                    //Thread.currentThread().getName()获取当前线程的名称
                    System.out.println(Thread.currentThread().getName() + "吃包子~" + i);
                }
                try {
                    System.out.println(Thread.currentThread().getName() + "休眠中");
                    Thread.sleep(20000);//20秒
                } catch (InterruptedException e) {
                    //当该线程执行到一个interrupt 方法时，就会catch一个异常，可以加入自己的业务代码
                    // InterruptedException是捕获到一个中断异常
                    System.out.println(Thread.currentThread().getName() + "被interrupt 了");
                }
            }
        }
    }





    /**
     * 1. yield:线程的礼让。让出cpu,让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功
     * 2. join:线程的插队。插队的线程一-旦插队成功， 则肯定先执行完插入的线程所有的任务
     * 案例:创建一个子线程,每隔1s输出hello,输出20次，主线程每隔1秒，输出hi ,输出20次,要求:两个线
     * 程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续，
     **/
    public static void testThreadMethod2() {
        threadMethod2 threadMethod2 = new threadMethod2();
        threadMethod2.start();
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                System.out.println("主线程(小弟)让子线程(老大) 先吃");
                try {
                    //这里相当于让threadMethod2线程先执行完毕
                    threadMethod2.join();
                    //礼让， 不一定成功..
                    //threadMethod2.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程(老大)吃完了主线程(小弟) 接着吃.");

            }

            System.out.println("主线程(小弟)吃了" + i + "包子");
        }

    }


    static class threadMethod2 extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(1000);//休眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程吃了(老大)" + i + "包子");
            }
        }
    }


    /**
     * 1.用户线程:也叫工作线程，当线程的任务执行完或通知方式结束
     * 2.守护线程: 一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
     * 3.常见的守护线程:垃圾回收机制
     **/
    public static void testMyDaemonThread() {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for(int i=1;i<=10;i++){
            //main线程
            System.out.println("宝强在辛苦的工作...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    static class MyDaemonThread extends Thread {
        @Override
        public void run() {
            for ( ; ; ) {//无限循环
                try {
                    Thread.sleep(1000);//休眠1000毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~");
            }
        }
    }

}
