package com.ycit.lambda;

/**
 * Created by xlch on 2017/3/4.
 */

import com.ycit.bean.Gender;
import com.ycit.bean.Person;

import java.util.List;

/**
 *
 * Drivers: Persons over the age of 16
 * Draftees: Male persons between the ages of 18 and 25
 * Pilots (specifically commercial pilots): Persons between the ages of 23 and 65
 */
public class QueryCase {

    public void callDriver(List<Person> persons) {
        for (Person person:persons) {
            if (isDriver(person)){
                call(person);
            }
        }
    }

    public void emailDraftees(List<Person> persons) {
        for (Person p:persons) {
            if (isDraftee(p)){
                email(p);
            }
        }
    }

    public void mailPilots(List<Person> persons) {
        for (Person p:persons) {
            if (isPilot(p)){
                mail(p);
            }
        }
    }

    /**-----------条件判断----------------**/

    public boolean isDriver(Person p) {
        return p.getAge() >= 16;
    }

    public boolean isDraftee(Person p) {
        return p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
    }

    public boolean isPilot(Person p) {
        return p.getAge() >= 23 && p.getAge() <= 65;
    }

    /**-----------通讯方式----------------**/

    public void call(Person person) {
        System.out.println(person);
    }

    public void mail(Person person) {
        System.out.println(person);
    }

    public void email(Person person) {
        System.out.println(person);
    }

}
