package com.lincheng.study.basejava.thread;

/**
 * @author linCheng
 * @date 2021/7/15 11:14
 */
public class StudyThreadLocal {

    /**
     * 用空间换时间 （sync = threadLocal）
     *
     */

    public static void main(String[] args) {
        //test1();
        //test2();
    }

    public static void test2(){
        MyDemo2 myDemo2 = new MyDemo2();
        for (int i = 0 ; i < 5 ; i++){
            new Thread(()->{
                myDemo2.setContext(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "=" + myDemo2.getContext());
            },"线程" + i).start();
        }
        /**
         * 线程0=线程0
         * 线程3=线程3
         * 线程4=线程4
         * 线程2=线程2
         * 线程1=线程1
         */
    }


    public static void test1(){
        MyDemo1 myDemo1 = new MyDemo1();
        for (int i = 0 ; i < 5 ; i++){
            new Thread(()->{
                myDemo1.setContext(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "=" + myDemo1.getContext());
            },"线程" + i).start();


            /*
            //可以解决
            new Thread(()->{
                synchronized (MyDemo1.class) {
                    myDemo1.setContext(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName() + "=" + myDemo1.getContext());
                }
            },"线程" + i).start();
            */
        }
    }

    //结果
    /**
     * 线程2=线程3
     * 线程1=线程4
     * 线程4=线程4
     * 线程0=线程3
     * 线程3=线程4
     */
}

class MyDemo1{

    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}


class MyDemo2{

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String context;

    public String getContext() {
        //return context;
        return threadLocal.get();
    }

    public void setContext(String context) {
        threadLocal.set(context);
        //this.context = context;
    }
}
