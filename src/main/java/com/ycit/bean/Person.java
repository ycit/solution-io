package com.ycit.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by xlch on 2017/3/3.
 */
public class Person {

    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
    private Gender gender;
    private String givenName;
    private String surName;

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public static class Builder{
        private String name = "";
        private int age = 0;
        private String email = "";
        private String phone = "";
        private String address = "";
        private Gender gender = Gender.MALE;
        private String givenName = "";
        private String surName = "";

        public Person.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Person.Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Person.Builder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public Person.Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Person.Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person.Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person.Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    private Person(){
        super();
    }

    private Person(Person.Builder builder) {
        name = builder.name;
        age = builder.age;
        gender = builder.gender;
        email = builder.email;
        address = builder.address;
        phone = builder.phone;
        surName = builder.surName;
        givenName = builder.givenName;
    }

    public void printWesternName() {
        System.out.println("western name:" + this.getGivenName() + " " + this.getSurName());
    }

    public void printEasternName() {
        System.out.println("eastern name:" + this.getSurName() + " " + this.getGivenName());
    }

    public String printCustom(Function<Person,String> function) {
        return function.apply(this);
    }



    public static List<Person> createList() {
        List<Person> persons = new ArrayList<>();
        persons.add(
                new Person.Builder()
                        .name("Bob")
                        .givenName("Bob")
                        .surName("Baker")
                        .age(21)
                        .gender(Gender.MALE)
                        .email("bob.baker@example.com")
                        .phone("201-121-4678")
                        .address("44 4th St, Smallville, KS 12333")
                        .build()
        );

        persons.add(
                new Person.Builder()
                        .name("john")
                        .givenName("John")
                        .surName("Doe")
                        .age(23)
                        .address("苏州市园区创意产业园")
                        .email("john@163.com")
                        .phone("0512-84623-324")
                        .gender(Gender.MALE)
                        .build()
        );
        persons.add(
                new Person.Builder()
                        .name("Jane")
                        .givenName("Jane")
                        .surName("Doe")
                        .age(25)
                        .gender(Gender.FEMALE)
                        .email("jane.doe@example.com")
                        .phone("202-123-4678")
                        .address("33 3rd St, Smallville, KS 12333")
                        .build()
        );
        persons.add(
                new Person.Builder()
                        .name("James")
                        .givenName("James")
                        .surName("Johnson")
                        .age(45)
                        .gender(Gender.MALE)
                        .email("james.johnson@example.com")
                        .phone("333-456-1233")
                        .address("201 2nd St, New York, NY 12111")
                        .build()
        );
        persons.add(
                new Person.Builder()
                        .name("Joe")
                        .givenName("Joe")
                        .surName("Bailey")
                        .age(67)
                        .gender(Gender.MALE)
                        .email("joebob.bailey@example.com")
                        .phone("112-111-1111")
                        .address("111 1st St, Town, CA 11111")
                        .build()
        );
        persons.add(
                new Person.Builder()
                        .name("Phil")
                        .givenName("Phil")
                        .surName("Smith")
                        .age(55)
                        .gender(Gender.MALE)
                        .email("phil.smith@examp;e.com")
                        .phone("222-33-1234")
                        .address("22 2nd St, New Park, CO 222333")
                        .build()
        );
        persons.add(
                new Person.Builder()
                        .name("Betty")
                        .givenName("Betty")
                        .surName("Jones")
                        .age(85)
                        .gender(Gender.FEMALE)
                        .email("betty.jones@example.com")
                        .phone("211-33-1234")
                        .address("22 4th St, New Park, CO 222333")
                        .build()
        );
        return persons;
    }














//    public Person() {
//    }
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public static List<Person> createList() {
//        Person p1 = new Person("bob",21);
//        Person p2 = new Person("john",25);
//        Person p3 = new Person("jack",23);
//        Person p4 = new Person("amy",27);
////        List<Person> persons = ImmutableList.of(p1, p2, p3, p4);不可变的list
//        List<Person> persons = new ArrayList<>();
//        persons.add(p1);
//        persons.add(p2);
//        persons.add(p3);
//        persons.add(p4);
//        return persons;
//    }
}
