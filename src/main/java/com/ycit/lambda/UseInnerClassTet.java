package com.ycit.lambda;

import com.ycit.bean.Gender;
import com.ycit.bean.Person;

import java.util.List;

/**
 * Created by xlch on 2017/3/5.
 */
public class UseInnerClassTet {

    public static void main(String [] args) {

        List<Person> persons = Person.createList();
        QueryCaseWithInnerClass innerClass = new QueryCaseWithInnerClass();

        innerClass.callContacts(persons, new MyTest<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >=16;
            }
        });

        innerClass.emailContacts(persons, new MyTest<Person>() {
            @Override
            public boolean test(Person p) {
                return  p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
            }
        });

        innerClass.mailContacts(persons, new MyTest<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge() >= 23 && p.getAge() <= 65;
            }
        });
    }

}
