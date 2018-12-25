package com.training.examples.stream_api;

import entities.Gender;
import entities.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PredicateTest {
    List<Person> personList;

    List<Person> sortPersons(List<Person> persons, Predicate<Person> personPredicate) {
        return persons.stream().filter(personPredicate).collect(Collectors.toList());
    }

    @Before
    public void init() {
        personList = Arrays.asList(
                new Person("Lola", 22, Gender.female),
                new Person("Ivan", 16, Gender.male),
                new Person("Igor", 15, Gender.male),
                new Person("Nick", 25, Gender.male),
                new Person("Ann", 21, Gender.female)
        );
    }

    @Test
    public void test1() {
        System.out.println(sortPersons(personList, PersonPredicates.isAdultFemale()));
    }

    @Test
    public void test2() {
        System.out.println(sortPersons(personList, PersonPredicates.isAdultMale()));
    }

    @Test
    public void patternRegexPredicateTest() {
        // Compile regex as predicate
        Predicate<String> emailFilter = Pattern
                .compile("^(.+)@example.com$")
                .asPredicate();

        List<String> emails = Arrays.asList("alex@example.com",
                "bob@yahoo.com",
                "cat@google.com",
                "david@example.com");

        List<String> desiredEmails = emails
                .stream()
                .filter(emailFilter)
                .collect(Collectors.toList());

        desiredEmails.forEach(System.out::println);

// Classic Version
        System.out.println();
        Pattern pattern = Pattern.compile("^(.+)@example.com$");
        emails.stream().forEach(s -> {
            if(pattern.matcher(s).matches()){
                System.out.println(s);
            }
        });

    }

}


class PersonPredicates {

    public static Predicate<Person> isAdultFemale() {
        return p -> p.getGender().equals(Gender.female) && p.getAge() > 17;
    }

    public static Predicate<Person> isAdultMale() {
        return p -> p.getGender().equals(Gender.male) && p.getAge() > 17;
    }
}