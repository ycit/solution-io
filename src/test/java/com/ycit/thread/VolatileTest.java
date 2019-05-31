package com.ycit.thread;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/5/21
 */
public class VolatileTest {

    private volatile int count = 0;

    @Test
    public void test() {
        new Thread(()->{
//            count++;
            if (count == 0 || count == 3) {
                count = 2;
                System.out.println(String.format("222 ,count is %d", count));
            }
        }).start();
        new Thread(()->{
//            count++;
            if (count == 0 || count == 2) {
                count = 3;
                System.out.println(String.format("3333 ,count is %d", count));
            }

        }).start();
        System.out.println(String.format("end ,count is %d", count));
    }

}
