package com.lincheng.study.common.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author linCheng
 * @date 2021/5/28 11:00
 */
public class ThreadUtil {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();

    private static ExecutorService taskExe = new ThreadPoolExecutor(10,20,200L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);

    /**
     * 在额外的线程执行对应的操作 -- 通过线程池来执行对应的操作
     */
    public static void runInNewThread(Runnable run) {
        if (run != null) {
            taskExe.execute(run);
        }
    }
}
