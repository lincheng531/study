package com.lincheng.study.basejava.thread;

import java.util.concurrent.*;

/**
 * @author linCheng
 * @date 2021/7/9 15:39
 */
public class StudyThreadPool {


    /**
     * corePoolSize：核心线程数
     * maximumPoolSize：最大线程数
     * keepAliveTime： 多余的空闲线程的存活时间
     *                 当前池中线程数量超过corePoolSize时，当空闲时间
     *                 达到keepAliveTime时，多余线程会被销毁直到
     *                 只剩下corePoolSize个线程为止
     * unit：存活时间的时间单位
     * workQueue ： 任务队列，被提交但尚未被执行的任务（阻塞队列）
     * threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认的即可
     * handler: 拒绝策略。表示当队列满了，并且工作线程大于
     *          等于线程池的最大线程数(maximumPoolSize) 时如何来拒绝
     *          请求执行的runnable的策略
     *
     *
     * 二、拒绝策略
     *     第一种拒绝策略是 AbortPolicy，这种拒绝策略在拒绝任务时，会直接抛出一个类型为 RejectedExecutionException 的 RuntimeException，让你感知到任务被拒绝了，于是你便可以根据业务逻辑选择重试或者放弃提交等策略。
     *
     *      第二种拒绝策略是 DiscardPolicy，这种拒绝策略正如它的名字所描述的一样，当新任务被提交后直接被丢弃掉，也不会给你任何的通知，相对而言存在一定的风险，因为我们提交的时候根本不知道这个任务会被丢弃，可能造成数据丢失。
     *
     *      第三种拒绝策略是 DiscardOldestPolicy，如果线程池没被关闭且没有能力执行，则会丢弃任务队列中的头结点，通常是存活时间最长的任务，这种策略与第二种不同之处在于它丢弃的不是最新提交的，而是队列中存活时间最长的，这样就可以腾出空间给新提交的任务，但同理它也存在一定的数据丢失风险。
     *
     *      第四种拒绝策略是 CallerRunsPolicy，相对而言它就比较完善了，当有新任务提交后，如果线程池没被关闭且没有能力执行，则把这个任务交于提交任务的线程执行，也就是谁提交任务，谁就负责执行任务。这样做主要有两点好处。
     *          第一点新提交的任务不会被丢弃，这样也就不会造成业务损失。
     *          第二点好处是，由于谁提交任务谁就要负责执行任务，这样提交任务的线程就得负责执行任务，而执行任务又是比较耗时的，在这段期间，提交任务的线程被占用，也就不会再提交新的任务，减缓了任务提交的速度，相当于是一个负反馈。在此期间，线程池中的线程也可以充分利用这段时间来执行掉一部分任务，腾出一定的空间，相当于是给了线程池一定的缓冲期。

     */
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

        //n 个、
        /**
         * 有多个生产者，可以并发生产产品，把产品置入队列中，如果队列满了，生产者就会阻塞；
         * 有多个消费者，并发从队列中获取产品，如果队列空了，消费者就会阻塞；
         */
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //1 个       阻塞队列
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //自定义      阻塞队列
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        //手动创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
