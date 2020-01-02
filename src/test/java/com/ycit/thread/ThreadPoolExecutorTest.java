package com.ycit.thread;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/10/22
 */
public class ThreadPoolExecutorTest {

    @Test
    public void ctlTest() {
        final int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        int RUNNING = (-1) << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
        int ctlOf = RUNNING | 0;
        int workCount = ctlOf & CAPACITY;
        System.out.println(RUNNING);
    }

}
