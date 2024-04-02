package com.phuoclet.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamReusable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");

        Stream<String> stream = list.stream()
                                    .filter(s -> s.length() > 3);

        stream.forEach(System.out::println);
        stream.forEach(s -> System.out.println(s.toUpperCase()));
        // So if you want to store this reference to a variable, you can store that but you can connect only one terminal operator
    }
}
