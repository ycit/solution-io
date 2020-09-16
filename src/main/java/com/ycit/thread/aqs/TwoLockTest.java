package com.ycit.thread.aqs;

/**
 * @author chenxiaolei
 * @date 2020/8/26
 */
public class TwoLockTest {

    public static void main(String[] args) {

        final TwoLock twoLock = new TwoLock();

        class Worker extends Thread {

            @Override
            public void run() {
                while (true) {
                    twoLock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        twoLock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            worker.interrupt();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
