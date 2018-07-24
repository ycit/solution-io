package com.ycit.container.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Stream;

public class SomeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SomeTest.class);

    @Test
    public void aTest() {

        List<String> names = new ArrayList<>();
        names.add("小明");
        names.add("小强");
        names.add("小红");
        names.add("小明");
        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println); // method reference

        Stream stream = Stream.builder().add("apple")
                .add("banana")
                .add("watermelon")
                .add("orange")
                .build();

    }

    @Test
    public void iteratorTest() {
        List<String> names = this.createList();
        for (Iterator<String> i = names.iterator(); i.hasNext();) {
            LOGGER.debug("name is {}", i.next());
        }
    }



    @Test
    public void forEachNewTest() {
        List<String> names = this.createList();
        for (String name:names) {
            LOGGER.debug("name is {}", name);
        }
    }

    @Test
    public void mistakeTest() {
        List<String> names = this.createList();
        List<String> fruits = this.createFruit();
        List<Person> source = new ArrayList<>();
        for (Iterator<String> i1 = names.iterator(); i1.hasNext();) {
            for (Iterator<String> i2 = fruits.iterator(); i2.hasNext();) {
                source.add(new Person(i1.next(), i2.next()));
            }
        }
        LOGGER.debug("source size is {}", source.size());
    }

    @Test
    public void mistakeFixTest() {
        List<String> names = this.createList();
        List<String> fruits = this.createFruit();
        List<Person> source = new ArrayList<>();
        for (Iterator<String> i1 = names.iterator(); i1.hasNext();) {
            String name = i1.next();
            for (Iterator<String> i2 = fruits.iterator(); i2.hasNext();) {
                source.add(new Person(name, i2.next()));
            }
        }
        LOGGER.debug("source size is {}", source.size());
    }

    @Test
    public void mistakeForEachTest() {
        List<String> names = this.createList();
        List<String> fruits = this.createFruit();
        List<Person> source = new ArrayList<>();
        for (String name:names) {
            for (String fruit:fruits) {
                source.add(new Person(name, fruit));
            }
        }
        LOGGER.debug("source size is {}", source.size());
    }

    @Test
    public void filterTest() {
        List<String> fruits = this.createFruit();
        for (Iterator<String> i = fruits.iterator(); i.hasNext();) {
            if (i.next().length() == 5) {
                i.remove();
            }
        }
        LOGGER.debug("fruits list size is {}", fruits.size());
    }

    @Test
    public void filterForEachTest() {
        List<String> fruits = this.createFruit();
        List<String> holds = new ArrayList<>(); //新集合接收
        for (String name:fruits) {
            if (name.length() == 5) {
                holds.add(name);
            }
        }
        LOGGER.debug("fruits list size is {}", fruits.size());
        LOGGER.debug("holds list size is {}", holds.size());
    }

    @Test
    public void retainTest() {
        List<String> names = this.createList();
        List<String> names2 = this.createList();
        List<String> names3 = this.createLinkedList();
        List<String> fruits = this.createFruit();
//        LOGGER.debug("retain all return is {}", names.retainAll(fruits));
        LOGGER.debug("retain all size is {}", names.size());
        LOGGER.debug("retain all return is {}",names.retainAll(names2));
        LOGGER.debug("retain all size is {}",names.size());
    }

    @Test
    public void failFastTest() {
        List<String> names = this.createList();
        for (Iterator iterator = names.iterator();iterator.hasNext();) {
//            iterator.next();
//            iterator.remove();
            names.remove(iterator.next());
        }
//        LOGGER.debug("names size is {}", names.size()); // 0
    }

    @Test
    public void inTest() {
        int i = 2;
        System.out.println(i++);
    }

    private List<String> createList() {
        List<String> names = new ArrayList<>();
        names.add("小明");
        names.add("小强");
        names.add("小红");
        names.add("小张");
        return names;
    }

    public static List<String> createFruit() {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("aaaaa");
        fruits.add("eeee");
        fruits.add("ddd");
        fruits.add("fff");
        return fruits;
    }

    public List<String> createLinkedList() {
        List<String> names = new LinkedList<>();
        names.add("小强");
        names.add("小红");
        names.add("小红");
        names.add(null);
        names.add(null);
        return names;
    }

    private class Person {
        private String name;
        private String fruit;

        public Person() {
        }

        public Person(String name, String fruit) {
            this.name = name;
            this.fruit = fruit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFruit() {
            return fruit;
        }

        public void setFruit(String fruit) {
            this.fruit = fruit;
        }
    }

    @Test
    public void mistakeTest2() {
        List<String> names = this.createList();
        List<String> fruits = this.createFruit();
        for (Iterator<String> i1 = names.iterator(); i1.hasNext();) {
            for (Iterator<String> i2 = fruits.iterator(); i2.hasNext();) {
                LOGGER.debug("name1 is {}, fruit is {}", i1.next(), i2.next());
            }
        }
    }

    @Test
    public void allTest() {
//
//        System.out.println("输入:");
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
//        int[][] array = new int[][]{};
//        for (int i = 0; i < num; i--) {
//            array[i][0] = i;
//            array[i][1] = 0;
//        }
        //首先创建Sanner类的对象；
        Scanner stu=new Scanner(System.in); //参数对象是系统进来的流
        System.out.println("请输入学生的姓名:");
        String sName=stu.next(); //next()方法用来接收控制台输入的字符串


        System.out.println("请输入学生的年龄：");
        int iAge=stu.nextInt();//nextInt（）方法接收控制台输入的整数
//下面输出刚才学生的姓名和年龄
        System.out.println("学生的姓名："+sName+"\t\t学生的年龄："+iAge);



    }



}
