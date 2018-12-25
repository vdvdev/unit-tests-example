package com.training.examples.stream_api;

import entities.Gender;
import entities.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GroupinByObjectsTest {
    List<Person> personList = Arrays.asList(
            new Person("Lena", 23, Gender.female),
            new Person("Ivan", 25, Gender.male),
            new Person("Victor", 26, Gender.male),
            new Person("Igor", 27, Gender.male),
            new Person("Lola", 25, Gender.female));

    @Test
    public void toArray(){
        String[] strings = personList.stream().map(p -> p.getName()).sorted().toArray(String[]::new);
        System.out.println(Arrays.asList(strings));
    }
}

