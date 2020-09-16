package com.ycit.proxy.jdk.v2;

/**
 * @author chenxiaolei
 * @date 2020/9/3
 */
public class SubjectImpl implements Subject {

    @Override
    public void doSomething() {
        System.out.println("do something ...");
    }
}
