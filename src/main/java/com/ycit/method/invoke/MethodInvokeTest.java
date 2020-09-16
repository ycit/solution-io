package com.ycit.method.invoke;

/**
 * @author chenxiaolei
 * @date 2020/7/25
 */
public class MethodInvokeTest {

    public static void main(String[]args) {
        MethodInvoke methodInvoke = new MethodInvoke();
        methodInvoke.invoke(null, 1);
        methodInvoke.invoke(null, 2);
        //手动绕开可变长参数的语法糖
        methodInvoke.invoke(null, new Object[]{1});
    }

}
