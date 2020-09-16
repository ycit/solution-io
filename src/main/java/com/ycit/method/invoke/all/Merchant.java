package com.ycit.method.invoke.all;

/**
 * 商户
 *
 * @author chenxiaolei
 * @date 2020/7/25
 */
public class Merchant {

    /**
     * 折后价
     * @return
     */
    public Number discount(double originalPrice, Customer customer){
            return originalPrice*0.8;
    }

}
