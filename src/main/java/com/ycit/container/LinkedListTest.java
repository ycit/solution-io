package com.ycit.container;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by xlch on 2017/4/25.
 */
public class LinkedListTest {

    /**
     * 验证 linkedList  ArrayList
     * @param args
     */
    public static void main(String [] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add(null);
        linkedList.add("2");
        linkedList.add(null);
        linkedList.forEach(System.out::println);
        System.out.println("---------------------------");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("3");
        hashSet.add(null);
        hashSet.add(null);
        hashSet.forEach(System.out::println);
        System.out.println("---------------------------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        linkedHashSet.add("3");
        linkedHashSet.add(null);
        linkedHashSet.add(null);
        linkedHashSet.forEach(System.out::println);
    }

}
