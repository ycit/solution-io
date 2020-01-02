package com.ycit.container.collection;

import org.junit.Test;

/**
 * @author chenxiaolei
 * @date 2019/11/19
 */
public class StringTest {

    @Test
    public void equalTest() {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1").intern();
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);

        String s4 = new String("1") + new String("1");
        s4.intern();
        String s5 = "11";
        System.out.println(s4 == s5);
    }

}
