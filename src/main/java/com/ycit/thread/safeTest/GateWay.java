package com.ycit.thread.safeTest;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class GateWay {

    private int counter = 0;
    private String name = "无名";
    private String address = "无地址";
    /**
     * 通行
     * @param name
     * @param address
     */
    public void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        checkPassport();
    }

    /**
     * 检查护照
     */
    private void checkPassport() {
        //名字和地址匹配上才能通过
        if(!this.name.equals(this.address)) {
            System.out.println("禁止通行:" + "第" + this.counter + "人，姓名：" + this.name + ",来自：" + this.address);
        }
    }

}
