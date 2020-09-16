package com.ycit.reference;

import com.ycit.bean.Dog;
import com.ycit.bean.Student;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 若引用
 *
 * @author chenxiaolei
 * @date 2020/8/15
 */
public class WeakReferenceTest extends WeakReference<Dog> {

    public WeakReferenceTest(Dog referent) {
        super(referent);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("WeakReferenceTest finalize run");
    }

    static WeakReferenceTest weakReferenceTest;
    static Dog dog;

    public static void getReference()throws Exception {


        Student student = new Student();
        student.setAddress("address");
        Dog dog = new Dog();
        dog.setName("XL");

        weakReferenceTest = new WeakReferenceTest(dog);
        System.gc();
        Thread.sleep(8000);
        System.out.println("getReference finish");
    }

    public static void main(String[] args) throws Exception {
        getReference();
        System.out.println("get dog " + weakReferenceTest.get());
        System.out.println("before main gc");
        System.gc();
        Thread.sleep(10000);
        System.out.println("get dog " + weakReferenceTest.get());
    }

}
