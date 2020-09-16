package com.ycit.proxy.jdk.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * @author chenxiaolei
 * @date 2020/9/3
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        Type[] types = method.getParameterTypes();
        System.out.println("methodName is " + name);
//        System.out.println(proxy.toString());
        System.out.println("before ...");
        Object obj = method.invoke(target, args);
        System.out.println("after ....");
        return obj;
    }
}
