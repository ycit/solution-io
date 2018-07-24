package com.ycit.stream;

import com.google.common.collect.ImmutableList;
import com.ycit.bean.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * stream 测试
 * <p>
 * Created by xlch at 2018/7/23
 */
public class StreamTest {

    public void stream() {
        Student student = new Student("bob", LocalDate.now());
        Student student1 = new Student("alice", LocalDate.now().plusYears(1));
        Student student2 = new Student("jack", LocalDate.now().plusYears(2));
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.stream();
    }

}
