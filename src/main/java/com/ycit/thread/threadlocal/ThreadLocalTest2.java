package com.ycit.thread.threadlocal;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxiaolei
 * @date 2020/8/19
 */
public class ThreadLocalTest2 {

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 0);

    public static void main(String[]args)throws Exception {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-local-test-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(), threadFactory);
        Thread thread = new Thread(()-> {
            threadLocal.set(3);
            threadLocal.set(5);
        });
        threadPoolExecutor.execute(thread);
        Thread.sleep(100000);
    }

}
