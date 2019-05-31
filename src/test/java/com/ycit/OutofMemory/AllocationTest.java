package com.ycit.OutofMemory;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/5/28
 */
public class AllocationTest {

    private final int _1MB = 1024*1024;

    /**
     * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    @Test
    public void test() {
        byte [] allocation1,allocation2,allocation3,allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

}
