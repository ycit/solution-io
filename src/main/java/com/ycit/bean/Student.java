package com.ycit.bean;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 学生类
 *
 * @author xlch
 * @create 2017-05-17 22:15
 */
public class Student {

    private String name;
    private String gender;
    private String address;
    private LocalDate birthday;

    public Student() {
    }

    public Student(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * 静态方法  根据年龄比较
     * @param a
     * @param b
     * @return
     */
    public static int compareByAge(Student a, Student b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals invoke,  equals obj: " + super.equals(o));
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        System.out.println(name + " hashcode is " + this.name.hashCode());
        return this.name.hashCode();
    }
}
