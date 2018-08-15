package com.ycit.thread;

import org.junit.Test;

/**
 * 线程测试
 * <p>
 * Created by xlch at 2018/8/13
 */
public class ThreadTest {

    @Test
    public void test() {
        Thread thread1 = new Thread(() -> {
            System.out.println("进入 thread1 ...");
            System.out.println("thread1 sleep...");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 sleep 苏醒, over");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("进入 thread2 ...");
            System.out.println("thread2 wait...");
            synchronized (thread1) {
                try {
                    thread1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread2 wait 苏醒, over");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("进入 thread3 ...");
            System.out.println("开始唤醒 thread2 ...");
            synchronized (thread1) {
                thread1.notify();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void counterTest() {
        Counter counter = new Counter();

        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increase();
                System.out.println( "thread name is :" +  Thread.currentThread().getName() + " c is :" + counter.getValue());
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.decrease();
                System.out.println( "thread name is :" +  Thread.currentThread().getName() + " c is :" + counter.getValue());
            }
        });
        a.start();
        b.start();
        System.out.println(counter.getValue());
    }
}
