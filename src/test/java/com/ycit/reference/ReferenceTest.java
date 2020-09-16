package com.ycit.reference;

import com.ycit.bean.Dog;
import com.ycit.bean.Student;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxiaolei
 * @date 2020/8/16
 */
public class ReferenceTest {

    WeakReference<Map<Dog, Student>> weakReference;

    @Test
    public void MapTest()throws Exception {
        build();
        System.out.println("before gc ...");
        System.gc();
        System.out.println("after gc ...");
        Thread.sleep(8000);

    }

    public void build() {
        Map<Dog, Student> dogStudentMap = new HashMap<>(3);
        Student student = new Student();
        student.setAddress("address");
        Dog dog = new Dog();
        dog.setName("XL");
        dogStudentMap.put(dog, student);
        weakReference = new WeakReference<>(dogStudentMap);
    }

}
