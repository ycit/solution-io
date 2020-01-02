package com.ycit.thread.difference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenxiaolei
 * @date 2020/1/2
 */
public class WaitTest {

    /**
     * 必须调用持有 monitor 的对象的wait 方法，否则报错 @see IllegalMonitorStateException
     * wait 同时释放持有的锁
     * @param args
     *  @see IllegalMonitorStateException
     */
    public static void main(String[]args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();
        Object object = new Object();
        for (int i = 1; i <= 4; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    synchronized (object) {
                        if (index % 2 == 0) {
                            object.wait(20000);
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
