package com.ycit.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenxiaolei
 * @date 2020/8/16
 */
public class ThreadId {

    private static AtomicInteger nextId = new AtomicInteger(0);

    private static ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int getId() {
        return threadId.get();
    }


    public static void main(String[]args) {
        for (int i =0;i<99;i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println("thread " + Thread.currentThread().getName() + " id is " + ThreadId.getId());
                }
            }.start();
        }
    }

}
