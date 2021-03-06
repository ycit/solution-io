package com.ycit.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by xlch on 2017/2/22.
 */
public class StringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringTest.class);

    public static void main(String[] args) throws Exception {
        short number = 4;
        int n = number + 5;
        float f = 3.4f;
        double d = 3.6;
        double d2 = d + n;
        float n2 = n + f;
        LOGGER.debug("d2 = {}", d2);
        LOGGER.debug("n2 = {}", n2);
        LOGGER.debug("n = {}", n);

        String s = "ABCDEFG";
        Class sClass = Class.forName("java.lang.String");
        Field valueField = sClass.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(s);
        int l = s.length() - 1;
        for (int j = (l - 1) >> 1; j >= 0; --j) {//有符号右移，高位补0，若无符号右移，高位补1
            char temp = value[j];
            char temp2 = value[l - j];//StringBuffer中下面会有一个验证
            value[l - j] = temp;
            value[j] = temp2;
        }
        LOGGER.debug("s === {}", s);
    }

}
