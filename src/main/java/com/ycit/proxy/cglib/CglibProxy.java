package com.ycit.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author chenxiaolei
 * @date 2020/9/3
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        return Enhancer.create(target.getClass(), this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before ....");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("after ...");
        return object;
    }
}
