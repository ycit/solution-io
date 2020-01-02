package com.ycit.thread.difference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenxiaolei
 * @date 2020/1/2
 */
public class SleepTest {

    /**
     * 若 sleep所在代码块 持有锁，则不会释放锁
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();
        Object object = new Object();
        for (int i = 1; i <= 4; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    synchronized (object) {
                        if (index % 2 == 0) {
                            Thread.sleep(20000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("index is " + index);
            });
        }
        executor.shutdown();
    }

}
