package com.ycit.base;

/**
 * object 测试
 *
 * @author xlch
 * @create 2017-06-06 13:28
 */
public class ObjectTest {

    public static void main(String [] args) {
        int [] arr = new int[]{2,3};
        String s1 = new String("2222");
        String s2 = new String("2222");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1==s2);
        System.out.println(arr.hashCode());
    }

}
