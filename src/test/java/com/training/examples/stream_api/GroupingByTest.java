package com.training.examples.stream_api;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByTest {

    List<String> stringCollection = Arrays.asList("a1", "b1", "c1", "c1", "a1");

    @Test
    public void toMap(){
        Map<String, String> stringStringMap = stringCollection.parallelStream().distinct()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toMap(s -> s.substring(0,1), s -> s));
        System.out.println(stringStringMap);
    }

    @Test
    public void toMapList(){
        Map<String, List<String>> stringListMap = stringCollection.stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0, 1), TreeMap::new,
                        Collectors.mapping((p) -> p.toUpperCase(), Collectors.toList())));
        System.out.println(stringListMap);


    }
}
