package com.ycit.thread.safeTest.my;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class PageThread2 extends Thread {

    private Buss buss;

    private String name;

    private String passport;

    PageThread2(Buss buss, String name, String passport) {
        this.buss = buss;
        this.name = name;
        this.passport = passport;
    }

    @Override
    public void run() {
        System.out.println(this.name + "，开始入关");
        while (true) {
            check();
//            this.buss.pass(name, passport);
        }

    }

    public void check() {
        if (!this.name.equals(this.passport)) {
            System.out.println("name " + name + " passport " + passport + "  不匹配");
        }
    }

}
