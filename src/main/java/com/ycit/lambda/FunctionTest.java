package com.ycit.lambda;

import com.ycit.bean.Person;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by xlch on 2017/3/5.
 */
public class FunctionTest {

    public static void main(String [] args) {
        // ① 传统的方法
        System.out.println("==========传统解决方法");
        List<Person> persons = Person.createList();
        for (Person person:persons) {
            person.printEasternName();
            person.printWesternName();
        }

        //② 自定义
        System.out.println("=========自定义");
        for (Person person:persons) {
            System.out.println(
                    person.printCustom(p -> "name:" + p.getGivenName())
            );
        }
        //③ 提前定义 Lambda 表达式
        Function<Person,String> westernNames = p -> "western name:" + p.getGivenName() + " " + p.getSurName();

        Function<Person,String> easternNames = p -> "eastern name:" + p.getSurName() + " " + p.getGivenName();

        System.out.println("============print western name");
        for (Person person:persons) {
            System.out.println(
                    person.printCustom(westernNames)
            );
        }

        System.out.println("============print eastern name");
        for (Person person:persons) {
            System.out.println(
                    person.printCustom(easternNames)
            );
        }

        System.out.println("=====collection forEach");
        persons.forEach(p -> p.printEasternName());
        persons.forEach(Person :: printEasternName);
        persons.forEach(p -> System.out.println(p.printCustom(e -> "giveName is " + e.getGivenName())));

        System.out.println("=====filter");
        persons.stream().filter(p -> p.getAge() >= 30).forEach(p -> System.out.println(p.getAge()));
        persons.forEach(p -> System.out.println(p.printCustom(e -> "age is " + e.getAge())));
        System.out.println("=====Make a new list after filtering.");
        List<Person> oldAges = persons.stream().filter(p -> p.getAge() >= 30).collect(Collectors.toList());
        oldAges.forEach(p -> System.out.println(p.printCustom(e -> "age is " + e.getAge())));

        System.out.println("===计算total average");
        long totalAge = persons.stream().filter(p -> p.getAge() >= 30).mapToInt(p -> p.getAge()).sum();
        System.out.println("totalAge ==" + totalAge);
        OptionalDouble average = persons.stream().filter(p -> p.getAge() >= 30).mapToDouble(p -> p.getAge()).average();
        System.out.println("average age ==" + average.getAsDouble());

    }

}
