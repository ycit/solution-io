package com.ycit.container.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * HashSet 测试
 * <p>
 * Created by xlch at 2018/6/8
 */
public class HashSetTest {

    @Test
    public void commonTest() {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("cc");
        set.forEach(System.out::println);
    }

    @Test
    public void linkedHashSetTest() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("aa");
        set.add("dd");
        set.add("ee");
        System.out.println(set);
    }

}
