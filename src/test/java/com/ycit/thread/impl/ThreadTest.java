package com.ycit.thread.impl;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chenxiaolei
 * @date 2019/4/24
 */
public class ThreadTest {

    class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    class ThreadImpl extends Thread {
        @Override
        public void run() {
            System.out.println(2);
        }
    }

    class CallableImpl implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 2;
            return ++sum;
        }

    }

    @Test
    public void test() {
        //Runnable
        Thread t1 = new Thread(new RunnableImpl());
        t1.start();
        // Thread
        Thread t2 = new ThreadImpl();
        t2.start();
        // callable :  特点，可以抛出异常,也可以获取线程执行的结果
        Callable<Integer> one = new CallableImpl();
        FutureTask<Integer> future = new FutureTask<>(one);
        Thread thread = new Thread(future);
        thread.start();
        try {
            System.out.println(future.get());;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
