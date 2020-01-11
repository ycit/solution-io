package com.ycit.container.collection;

import com.ycit.bean.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

/**
 * hashmap test
 * <p>
 * Created by xlch at 2018/6/11
 */
public class HashMapTest {

    @Test
    public void commonTest() {
        HashMap map = new HashMap();
        int size = tableSizeFor(4);
        int size2 = tableSizeFor(-1);
        System.out.println(size);
        System.out.println(size2);
        for (int i = 0;i < 4; ++i) {
            System.out.println(i);
        }
        Object[]array = new Object[4];
        System.out.println(array.length);
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1; // 5
        n |= n >>> 1; //  n = 0101 | 0010 = 0111
        n |= n >>> 2; // 0111 | 0001 = 0111
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >=1 << 30) ? 1 << 30 : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Test
    public void testHash() {
        System.out.println(hash("2"));;
    }

    @Test
    public void sizeTest() {
        Map<String, String> map = new HashMap<>();
        map.put("244", "111");
        map.put("你好", "111");
        map.put("544", "111");
        map.put("aa", "111");
        map.put("444", "111");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry:entrySet) {
            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
        }
        System.out.println(map);
    }

    @Test
    public void linkedHashMapTest() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("2", "111");
        map.put("1", "111");
        map.put("5", "111");
        map.put("3", "111");
        map.put("4", "111");
        map.put("2", "2222");
        System.out.println(map);
    }

    @Test
    public void collisionTest() {
        Student student = new Student("小明", LocalDate.of(2018, 4, 5));
        Student student2 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student3 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student4 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student5 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student6 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student7 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student8 = new Student("小明", LocalDate.of(2018, 4, 7));
        Student student9 = new Student("小明", LocalDate.of(2018, 4, 7));
        HashMap<Student, String> map = new HashMap<>();
        map.put(student, "1");
        map.put(student2, "1");
        map.put(student3, "1");
        map.put(student4, "1");
        map.put(student5, "1");
        map.put(student6, "1");
        map.put(student7, "1");
        map.put(student8, "1");
        map.put(student9, "1");
    }

}
