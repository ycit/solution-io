package com.ycit.thread;

/**
 * @author chenxiaolei
 * @date 2019/10/22
 */
public class VolatileTest {

    int x = 0;
    volatile  boolean v = false;

    public void write() {
        x=42;
        v=true;
    }

    public void read(){
        System.out.println(x);
        if (v) {
            System.out.println(x);
        }
    }

    public static void main(String[]args)throws Exception {
        VolatileTest volatileTest = new VolatileTest();
        Thread t1 = new Thread(()-> {
            volatileTest.write();
        });

        Thread t2 = new Thread(()-> {
            volatileTest.read();
        });

        t2.start();
        t1.start();
    }

}
