package com.ycit.lambda;

import com.ycit.bean.Student;
import com.ycit.lambda.util.ComparisonProvider;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

/**
 * Created by xlch at 2018/5/31
 */
public class MethodReferenceTest {


    @Test
    public void methodReferenceTest() {
        Student zs = new Student("张三", LocalDate.parse("19920803", DateTimeFormatter.ofPattern("yyyyMMdd")));
        Student ls = new Student("李四", LocalDate.parse("19901003", DateTimeFormatter.ofPattern("yyyyMMdd")));
        List<Student> students = new ArrayList<>();
        students.add(zs);
        students.add(ls);
        Student[] studentArray = students.toArray(new Student[students.size()]);

        //原始写法
        Arrays.sort(studentArray, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        // lambda 表达式写法
        Comparator<Student> comparatorLambda =  (a, b) -> a.getBirthday().compareTo(b.getBirthday());
        Arrays.sort(studentArray, comparatorLambda);

        //  ① 静态方法引用
        Comparator<Student> comparatorStatic = Student::compareByAge; // 这里使用的函数接口为 Comparator<T>
        Arrays.sort(studentArray, comparatorStatic);

        //  ② 特定对象的实例方法引用
        ComparisonProvider provider = new ComparisonProvider();
        Comparator<Student> comparatorSpecific = provider::compareByName;
        Arrays.sort(studentArray, comparatorSpecific);

        //  ③ 特定类型的任意对象的实例方法引用
        String[] stringArray ={ "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        Arrays.sort(stringArray, (s1, s2) -> s1.compareToIgnoreCase(s2)); // 特定类型的任意对象的实例方法引用 转为 lambda 写法

        //  ④ 构造函数引用
        Supplier<HashSet<Student>> supplier = HashSet::new; // 构造 Supplier 函数式接口
        Supplier<HashSet<Student>> supplier2 = () -> new HashSet<>(); // 构造 Supplier 函数式接口
        Set<Student> r2 = transferElements(students, supplier);
        Set<Student> r3 = transferElements(students, HashSet<Student>::new);
        Set<Student> r1 = transferElements(students, supplier2); // 构造函数引用转化成 lambda 表达式 写法

        // 使用 Comparator 中的方法——lambda 表达式
        Arrays.sort(studentArray, Comparator.comparing(student ->student.getBirthday()));
        // 使用 Comparator 中的方法——方法引用
        Arrays.sort(studentArray, Comparator.comparing(Student::getBirthday));

        Arrays.stream(stringArray).forEach(System.out::println);
        Arrays.stream(studentArray).forEach(student -> System.out.println(student.getName()));

    }

    /**
     *  将元素从一个集合拷贝到另一个集合
     * @param sourceCollection
     * @param collectionFactory
     * @param <T>
     * @param <SOURCE>
     * @param <DEST>
     * @return
     */
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }


}
