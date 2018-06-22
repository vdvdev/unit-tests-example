package com.training.examples.stream_api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStreamTest {
    @Test
    public void sumTest(){
        List<Integer> integerList = Arrays.asList(2,3,4,6);
        System.out.println(integerList.stream().mapToInt(s->s).sum());
        System.out.println(integerList.stream().reduce((s1,s2)-> s1+s2).orElse(0));
    }

    @Test
    public void filterTest(){
        String[] strings = {"abbs", "tresh", "3erw", "223"};
        int reqLong = 4;
        System.out.println(Arrays.stream(strings).filter(s->s.length() == reqLong)
                .collect(Collectors.toList()));
        System.out.println(Arrays.stream(strings).parallel().filter(s->s.length() == reqLong)
                .count());
        System.out.println(Arrays.stream(strings).filter(s->s.length() == reqLong)
                .collect(Collectors.joining(", ")));
    }

    @Test
    public void sortedTest(){
        Integer[] ints = {3,15,9,7,9};
        System.out.println(
                Arrays.stream(ints).distinct().filter(s -> s>3).sorted().collect(Collectors.toList())
        );
    }

}
