package com.lincheng.study.basejava.thread;

import java.util.concurrent.*;

/**
 * @author linCheng
 * @date 2021/7/9 15:39
 */
public class StudyThreadPool {


    public static void main(String[] args) {
        testNewFixedThreadPool();
    }


    private static void testNewFixedThreadPool(){

        //执行长期任务性能好，创建一个线程池，池有N个固定的线程，有固定线程数的线程
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0 ; i < 10 ; i++){
                newFixedThreadPool.execute(()->{
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            newFixedThreadPool.shutdown();
        }
    }



    private static void test() {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

    }

}
