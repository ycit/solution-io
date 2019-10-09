package com.ycit.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author chenxiaolei
 * @date 2019/10/9
 */
public class ProxyTest {

    public static void main(String[]args) {
        Animal dog = new Dog();
        Animal proxy = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(), Dog.class.getInterfaces(), new AnimalInvocationHandler(dog));
        proxy.say();
        System.out.println(proxy.getClass());
    }

}
