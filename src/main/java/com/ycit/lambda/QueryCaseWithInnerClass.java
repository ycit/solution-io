package com.ycit.lambda;

import com.ycit.bean.Person;

import java.util.List;

/**
 * Created by xlch on 2017/3/5.
 */
public class QueryCaseWithInnerClass {

    public void callContacts(List<Person> persons, MyTest<Person> myTest) {
        for (Person person:persons) {
            if (myTest.test(person)){
                call(person);
            }
        }
    }

    public void emailContacts(List<Person> persons, MyTest<Person> myTest) {
        for (Person p:persons) {
            if (myTest.test(p)){
                email(p);
            }
        }
    }

    public void mailContacts(List<Person> persons, MyTest<Person> myTest) {
        for (Person p:persons) {
            if (myTest.test(p)){
                mail(p);
            }
        }
    }

    /**-----------通讯方式----------------**/

    public void call(Person person) {
        System.out.println("call :" +person.getName());
    }

    public void mail(Person person) {
        System.out.println("mail:" + person.getName());
    }

    public void email(Person person) {
        System.out.println("email:" + person.getName());
    }

}
