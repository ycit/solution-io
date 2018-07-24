package com.ycit.container.collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xlch at 2018/5/31
 */
public class LinkedListTest {

    @Test
    public void baseTest() {
        List<String> names = this.createLinkedList();
        names.remove("bob");
        names.forEach(System.out::println);
    }

    private List createLinkedList() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("bob");
        linkedList.add("alice");
        linkedList.add("john");
        linkedList.add("bob");
        return linkedList;
    }

}
