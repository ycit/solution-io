package com.ycit.container.collection;

import com.ycit.bean.Dog;
import com.ycit.bean.Person;
import com.ycit.bean.Student;
import com.ycit.lambda.custom.Foo;
import com.ycit.lambda.custom.UseFoo;
import com.ycit.lambda.util.ComparisonProvider;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * ArrayList 相关测试
 * <p>
 * Created by xlch at 2018/5/28
 */
public class ArrayListTest {

    @Test
    public void methodTest() {
        List<String> fruits = this.createFruit();
        //forEach方法 的 lambda
        fruits.forEach(fruit -> {
            System.out.println(fruit);
        });
        //forEach方法 的方法引用
        fruits.forEach(System.out::println);


        // removeIf 方法
        fruits.removeIf(s -> s.equals("orange"));

        // replaceAll 方法
        fruits.replaceAll(s -> {
            if ("apple".equals(s)) {
                return "watermelon";
            }
            return s;
        });
        // 避免 lambda 体的 写法
        fruits.replaceAll(this::unaryOperator);
        System.out.println(fruits);
    }

    private String unaryOperator(String s) {
        if ("apple".equals(s)) {
            return "watermelon";
        }
        return s;
    }

    public List<String> createFruit() {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        return fruits;
    }

    @Test
    public void customFunctional() {
        UseFoo useFoo = new UseFoo();
        Foo foo = param -> param + " from lambda";
        String result = useFoo.add("Message", foo);
        System.out.println(result);
    }

    @Test
    public void practise() {
        Function<String, String> function = this::buildStr;
//        Function<String, String> function1 = param -> buildStr(param); // 和此等价
        String result = add(" Message ", function);
        System.out.println(result);

    }

    public String buildStr(String param) {
        //many code
        return " something " + param;
    }

    public String add(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void test() {
        Dog dog = new Dog();
        Dog dog1 = new Dog();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        dogs.add(dog1);
        dog.setName("xx");
        dog1.setName("mm");
        System.out.println(dogs);
        dogs.stream().map(Dog::getName).toString();
    }

}
