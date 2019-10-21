package com.ycit.thread.clh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 简易 clh 锁队列 实现的自旋锁
 *
 * @author chenxiaolei
 * @date 2019/10/21
 */
public class ClhSpinLock {

    /**
     * 前置节点:默认为空
     */
    private final ThreadLocal<Node> prev = ThreadLocal.withInitial(()->null);
    /**
     * 当前节点，ThreadLocal 使每个线程创建的 Node 都不同，互相不影响
     */
    private final ThreadLocal<Node> node = ThreadLocal.withInitial(Node::new);
    /**
     * 原子操作类
     */
    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    public ClhSpinLock() {
    }

    public void lock() {

        //获取当前节点
        final Node node = this.node.get();
        //为当前节点上锁
        node.locked = true;
        // 一个CAS操作即可将当前线程对应的节点加入到队列中，
        // 并且同时获得了前继节点的引用，然后就是等待前继释放锁
        //sets to the given value and returns the old value. 当前节点添加到原子引用中，并获取前一个值
        Node pred = this.tail.getAndSet(node);
        // 将前一个值设置为前置节点
        this.prev.set(pred);
        // 不停轮询前驱节点是否释放锁，第一个线程进入时 pred.locked 默认为false ,
        // 第二个线程进入时等待的是第一个线程的节点为true,无限循环直到unlock 释放
        while (pred.locked) {
        }
    }

    public void unlock() {
        final Node node = this.node.get();
        node.locked = false;
        this.node.set(this.prev.get());
    }

    private static class Node {
        private volatile boolean locked;
    }

    public static void main(String[] args)throws Exception {
        final ClhSpinLock lock = new ClhSpinLock();
        lock.lock();

        ExecutorService excutorService =  Executors.newFixedThreadPool(6);
        for (int i = 0; i < 2; i++) {
            excutorService.execute(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " acquired the lock!");
                lock.unlock();
            });
            Thread.sleep(100);
        }

        System.out.println("main thread unlock!");
        lock.unlock();
    }

}
