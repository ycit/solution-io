package com.ycit.thread.queue;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 *
 * @author chenxiaolei
 * @date 2019/11/13
 */
public class Producer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) { blockingQueue.put(produce()); }
        } catch (InterruptedException ex) {

        }
    }

    public String produce() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = "1";
        System.out.println("produce " + s);
        return s;
    }
}
