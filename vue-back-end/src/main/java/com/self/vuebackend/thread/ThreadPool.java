package com.self.vuebackend.thread;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ThreadPool {

    /**
     * 测试线程池
     */
    private static ExecutorService testExecutorService = new ThreadPoolExecutor(10, 20, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000));

}
