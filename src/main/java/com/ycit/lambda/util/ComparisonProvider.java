package com.ycit.lambda.util;

import com.ycit.bean.Student;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * 比较器
 * <p>
 * Created by xlch at 2018/5/30
 */
public class ComparisonProvider {

    public int compareByName(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByBirthday(Student a, Student b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }


}
