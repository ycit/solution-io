package com.ycit.thread.interrupt;

/**
 *  interrupt() 方法不会中断正在执行的线程， 只有阻塞的线程会抛出 interruptedException
 * 中断测试
 * @author chenxiaolei
 * @date 2020/8/22
 */
public class InterruptTest {

    public static void main(String[]args)throws Exception {

        Thread t1 = new Thread(()-> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("is interrupted");
                } else {
                    System.out.println("not interrupted");
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("receive interrupted msg");
                }
            }
        });
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();
//        Thread.sleep(1000000);
        System.out.println(Thread.interrupted());

    }

}
