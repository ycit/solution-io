package com.ycit.thread.cyclicbarrier;

/**
 * @author chenxiaolei
 * @date 2020/8/19
 */
public class ABCTest2 {

    private int n;

    private volatile int flag = 0;

    public ABCTest2(int n) {
        this.n = n;
    }

    public synchronized void printA(Runnable aPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            while (flag != 0) {
                this.wait();
            }
            aPrint.run();
            flag = 1;
            this.notifyAll();
        }
    }

    public synchronized void printB(Runnable bPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            while (flag != 1) {
                this.wait();
            }
            bPrint.run();
            flag = 2;
            this.notifyAll();
        }
    }

    public synchronized void printC(Runnable cPrint)throws InterruptedException {
        for (int i = 0; i< n; i++) {
            while (flag != 2) {
                this.wait();
            }
            cPrint.run();
            flag = 0;
            this.notifyAll();
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
