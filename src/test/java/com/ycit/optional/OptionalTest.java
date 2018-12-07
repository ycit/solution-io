package com.ycit.optional;

import com.ycit.bean.Person;
import com.ycit.bean.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

/**
 * java 8 optional test
 * <p>
 * Created by Administrator at 2018/12/7
 */
public class OptionalTest {

    @Test
    public void nullPointExceptionTest() {
        Student student = null;
        System.out.println(student.getAddress());
    }

    @Test
    public void optionalTest() {
        Optional<Student> studentOptional = Optional.ofNullable(null);
        studentOptional.ifPresent(student1 -> {
            System.out.println(student1.getAddress());
        });
    }

    @Test
    public void orElseTest() {
        Optional<Student> studentOptional = Optional.ofNullable(null);
        Student student = studentOptional.orElse(new Student("xlch", LocalDate.now()));
        System.out.println(student.getName());
    }

    @Test
    public void orElseGetTest() {
        Optional<Student> studentOptional = Optional.ofNullable(null);
        Student student = studentOptional.orElseGet(() -> new Student("ssx", LocalDate.now()));
        System.out.println(student.getName());
    }

    @Test
    public void mapTest() {
        Optional<Student> studentOptional = Optional.ofNullable(new Student("rxc", LocalDate.now()));
        Optional<String> optionalS = studentOptional.map(Student::getName);
        optionalS.ifPresent(System.out::print);
    }

}
