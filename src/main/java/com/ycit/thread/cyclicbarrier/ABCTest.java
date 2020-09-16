package com.ycit.thread.cyclicbarrier;

import java.util.concurrent.Semaphore;

/**
 * @author chenxiaolei
 * @date 2020/8/19
 */
public class ABCTest {


    private static Object object = new Object();

    private static Semaphore as = new Semaphore(1);

    private static Semaphore bs = new Semaphore(0);

    private static Semaphore cs = new Semaphore(0);


    private int n;


    public ABCTest(int n) {
        this.n = n;
    }

    public synchronized void printA(Runnable aPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            as.acquire();
            aPrint.run();
            bs.release();
        }
    }

    public synchronized void printB(Runnable bPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            bs.acquire();
            bPrint.run();
            cs.release();
        }
    }

    public synchronized void printC(Runnable cPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            cs.acquire();
            cPrint.run();
            as.release();
        }
    }

    public static void main(String[]args) throws Exception{
        ABCTest2 abcTest2 = new ABCTest2(4);
        new Thread(()-> {
            try {
                abcTest2.printA(() -> {
                    System.out.print("A");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                abcTest2.printB(() -> {
                    System.out.print("B");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                abcTest2.printC(() -> {
                    System.out.print("C");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10000);
    }
}
