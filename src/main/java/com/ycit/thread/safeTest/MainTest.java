package com.ycit.thread.safeTest;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class MainTest {

    public static void main(String[]args) {
        System.out.println("开始入关");
        GateWay gate = new GateWay();
        new Person(gate, "张三", "张三").start();
        new Person(gate, "李四", "李四").start();
        new Person(gate, "王五", "王五").start();
        new Person(gate, "赵六", "赵六").start();
    }

}
