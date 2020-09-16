package com.ycit.thread.safeTest;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class Person extends Thread {

    private final GateWay gateWay;
    private final String name;
    private final String address;

    public Person(GateWay gateWay, String name, String address) {
        this.gateWay = gateWay;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(this.name + "，开始入关");
        while(true) {
            this.gateWay.pass(this.name, this.address);
        }
    }

}
