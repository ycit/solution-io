package com.ycit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenxiaolei
 * @date 2019/10/9
 */
public class AnimalInvocationHandler implements InvocationHandler {

    private final Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" --------------before ------------");
        Object object = method.invoke(animal, args);
        System.out.println("--------------after--------------");
        return object;
    }

}
