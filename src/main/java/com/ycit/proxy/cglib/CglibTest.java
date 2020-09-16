package com.ycit.proxy.cglib;

import com.ycit.proxy.jdk.Dog;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author chenxiaolei
 * @date 2020/9/3
 */
public class CglibTest {

    public static void main(String[]args) {
        Dog dog = new Dog();
        System.out.println(dog.toString());
        CglibProxy cglibProxy = new CglibProxy();
        Object object = cglibProxy.getProxy(dog);
        System.out.println(object.toString());
        Dog obj = (Dog)object;
        System.out.println(obj.toString());
        obj.say();

    }

}
