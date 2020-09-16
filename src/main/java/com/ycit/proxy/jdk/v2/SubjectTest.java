package com.ycit.proxy.jdk.v2;

/**
 * @author chenxiaolei
 * @date 2020/9/3
 */
public class SubjectTest {

    public static void main(String[]args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        Subject subject = new SubjectImpl();
        Subject proxySubject = (Subject) proxyHandler.getProxy(subject);
        System.out.println(proxySubject.getClass().getName());
        System.out.println(subject.getClass().getName());
        proxySubject.doSomething();

    }

}
