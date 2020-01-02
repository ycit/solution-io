package com.ycit.thread.queue;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 *
 * @author chenxiaolei
 * @date 2019/11/13
 */
public class Consumer implements Runnable {

    private final BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumer(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumer(String o) {
        System.out.println("consumer ...");
    }

}
