package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoCollectToJoining {
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

        String newString = list.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining(";"));

        System.out.println("Original :: " + list);
        // I would like to join those words into a single string
        System.out.println("String :: " + newString);
    }
}
