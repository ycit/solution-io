package com.ycit.or;

/**
 * @author uk
 * 2019/9/21 15:50
 */
public class Father {

    public Father() {
        eat();
    }

    public void eat() {
        System.out.println("father eating ...");
    }

    public static void main(String[]args) {
        Father father = new Father();
    }

}
