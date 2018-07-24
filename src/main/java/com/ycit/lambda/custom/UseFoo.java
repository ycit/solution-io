package com.ycit.lambda.custom;

import java.util.function.Function;

/**
 * Created by xlch at 2018/5/31
 */
public class UseFoo {

    public String add(String str, Foo foo) {
        return foo.method(str);
    }

    public String add(String str, Function<String, String> function) {
        return function.apply(str);
    }

}
