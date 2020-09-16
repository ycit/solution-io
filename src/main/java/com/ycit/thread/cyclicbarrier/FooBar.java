package com.ycit.thread.cyclicbarrier;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *   ABC ABC 顺序输出
 * @author chenxiaolei
 * @date 2020/8/19
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }




    private volatile int flag = 0;


    public void foo(Runnable printFoo) throws InterruptedException  {

        for (int i = 0; i < n; i++) {
            while (flag != 0) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = 1;

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag != 1) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = 0;
        }
    }

    public static void main(String[]args)throws Exception {
        FooBar fooBar = new FooBar(3);


        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(()->{
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                fooBar.bar(()->{
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
        Thread.sleep(100000);
    }

}
