package com.ycit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 狗
 *
 * @author chenxiaolei
 * @date 2019/10/9
 */
public class Dog implements Animal {

    @Override
    public void say() {
        System.out.println("汪汪汪 ...");
    }

}
