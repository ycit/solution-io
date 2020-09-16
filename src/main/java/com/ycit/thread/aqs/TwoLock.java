package com.ycit.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author chenxiaolei
 * @date 2020/8/26
 */
public class TwoLock {

    Sync sync = new Sync(2);

    class Sync extends AbstractQueuedSynchronizer {

        Sync(int arg) {
            if (arg < 0) {
                throw new Error("must > 0");
            }
            setState(arg);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int current = getState();
                int remaining = current - arg;
                if (remaining < 0 || compareAndSetState(current, remaining)) {
                    return remaining;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;) {
                int current = getState();
                int next = current + arg;
                if ( next < current) {
                    throw new Error("Maximum permit count exceeded");
                }
                if (compareAndSetState(current, next)) {
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }
}
