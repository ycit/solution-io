package com.ycit.thread.safeTest.my;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class Buss {

    private String name;

    private String passport;

    public void pass (String name, String passport) {
        this.name = name;
        this.passport = passport;
        check();
    }

    public void check() {
        if (!this.name.equals(this.passport)) {
            System.out.println("name " + name + " passport " + passport + "  不匹配");
        }
    }
}
