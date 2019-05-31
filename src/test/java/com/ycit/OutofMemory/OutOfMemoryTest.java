package com.ycit.OutofMemory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxiaolei
 * @date 2019/5/27
 */
public class OutOfMemoryTest {

    /**
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void heapTest() {
        List<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new Object());
        }
    }

    /**
     * -Xss
     */
    @Test
    public void stackLeakByThread() {
        while (true) {
            new Thread(OutOfMemoryTest::dontStop).start();
        }
    }

    private static void dontStop() {
        while (true) {

        }
    }

    @Test
    public void methodAreaTest() {
        List<String> strings = new ArrayList<>();
        int i = 0;
        while (true) {
            strings.add(String.valueOf(i++).intern());
        }
    }

    @Test
    public void strTest() {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }



}
