package com.ycit.lambda;

/**
 * Created by xlch on 2017/3/2.
 */
public class RunnableTest {

    public static void main(String [] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("normal Anonymous Inner class");
            }
        };

        Runnable runnable1 = () -> System.out.println("Lambda Expression");

        runnable.run();
        runnable1.run();
    }
}
