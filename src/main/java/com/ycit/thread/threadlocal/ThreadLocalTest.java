package com.ycit.thread.threadlocal;

import com.ycit.bean.Dog;

/**
 * @author chenxiaolei
 * @date 2020/6/18
 */
public class ThreadLocalTest {

    public static void main(String[]args) {
        new Thread() {
            @Override
            public void run() {
                update(1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + Thread.currentThread() + " age is " + threadLocal.get().getAge());
                update(1);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + Thread.currentThread() + " age is " + threadLocal.get().getAge());
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                update(2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + Thread.currentThread() + " age is " + threadLocal.get().getAge());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                update(3);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + Thread.currentThread() + " age is " + threadLocal.get().getAge());
            }
        }.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadLocal.remove();
        threadLocal = null;
//        System.gc();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ThreadLocal<Dog> threadLocal = ThreadLocal.withInitial(() -> {
        Dog dog = new Dog();
        dog.setAge(10);
        return dog;
    });

    public static void update(int age) {
        Dog dog = threadLocal.get();
        dog.setAge(dog.getAge() + age);
    }

}
