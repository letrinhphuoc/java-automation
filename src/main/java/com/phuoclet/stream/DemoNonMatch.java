package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.List;

public class DemoNonMatch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");

        System.out.println(
                list.stream()
                        .filter(s -> s.length() > 3)
                        .noneMatch(s -> s.contains("z"))
        );
    }
}
