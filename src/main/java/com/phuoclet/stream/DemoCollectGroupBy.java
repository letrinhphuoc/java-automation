package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoCollectGroupBy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple");
        list.add("Airplane");
        list.add("Ball");
        list.add("Boy");
        list.add("Cat");
        list.add("Dog");
        list.add("Delta");

        Map<Integer, List<String>> map = list.stream()
                                             .collect(Collectors.groupingBy(s -> s.length()));

        Map<Character, List<String>> mapChar = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(map);
        System.out.println(mapChar);

    }
}
