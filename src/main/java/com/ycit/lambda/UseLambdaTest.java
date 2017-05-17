package com.ycit.lambda;

import com.ycit.bean.Gender;
import com.ycit.bean.Person;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by xlch on 2017/3/5.
 */
public class UseLambdaTest {

    public static void main(String[]args) {
        List<Person> persons = Person.createList();
        QueryCaseWithFunction robo = new QueryCaseWithFunction();

        Predicate<Person> drivers = person -> person.getAge() >= 16;
        Predicate<Person> draftees = person -> person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Gender.MALE;
        Predicate<Person> pilots = person -> person.getAge() >= 23 && person.getAge() <= 65;

        robo.callContacts(persons, drivers);
        robo.callContacts(persons, draftees);
        robo.callContacts(persons, pilots);
        robo.emailContacts(persons, draftees);
        robo.mailContacts(persons, pilots);
    }

}
