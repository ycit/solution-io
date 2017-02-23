package com.ycit;

import com.ycit.innerclass.PropertySource;
import com.ycit.innerclass.PropertySource.StubPropertySource;
import org.junit.Test;

/**
 * Created by xlch on 2017/1/25.
 */
public class InnerClassTest {

    @Test
    public void propertyTest() {
        PropertySource p = new StubPropertySource("file");
        System.out.println(p);
    }

}
