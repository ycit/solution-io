package com.ycit.thread;

/**
 * Created by xlch at 2018/8/14
 */
public class Counter {

    private int c = 0;

    public void increase() {
        c++;
    }

    public void decrease() {
        c--;
    }

    public int getValue() {
        return c;
    }

}
