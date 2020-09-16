package com.ycit.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenxiaolei
 * @date 2020/8/26
 */
public class CountDownLatchTest {

    public static void main(String[]args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread current = Thread.currentThread();
        for (int i=0; i< 10; i++) {
            Worker worker = new Worker(countDownLatch, i, current);
            worker.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main interrup run");
    }

    static class Worker extends Thread {

        private CountDownLatch countDownLatch;

        private int num;

        private Thread main;

        Worker(CountDownLatch countDownLatch, int num, Thread thread) {
            this.countDownLatch = countDownLatch;
            this.num = num;
            this.main = thread;
        }

        @Override
        public void run() {
            if (num == 5) {
                main.interrupt();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("i = " + num + " has count down");
        }
    }

}
