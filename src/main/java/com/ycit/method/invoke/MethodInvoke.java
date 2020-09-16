package com.ycit.method.invoke;

/**
 * @author chenxiaolei
 * @date 2020/7/25
 */
public class MethodInvoke {

    public void invoke(Object object, Object ...args) {
        System.out.println("invoke object");
    }

    public void invoke(String str, Object object, Object...args) {
        System.out.println("invoke string");
    }

}
