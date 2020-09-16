package com.ycit.bean;

/**
 * @author chenxiaolei
 * @date 2019/11/13
 */

public class Dog {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("dog finalize run..");
    }
}
