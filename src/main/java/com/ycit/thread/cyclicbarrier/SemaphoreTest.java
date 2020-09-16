package com.ycit.thread.cyclicbarrier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chenxiaolei
 * @date 2020/8/19
 */
public class SemaphoreTest {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();
        // 每次最多三个线程获取许可
        final Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.release(1);
                    semaphore.acquire(1);
                    System.out.println("thread " + Thread.currentThread().getName() + " time " + getFormatTimeStr());
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
        }
        exec.shutdown();
    }

    public static String getFormatTimeStr() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static void test(int threadNum) throws Exception {
        System.out.println("threadNum " + threadNum);
        Thread.sleep(1000);
    }

}
