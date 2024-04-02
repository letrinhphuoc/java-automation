package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DemoMinMax {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");

        System.out.println(
                list.stream()
                    .min(Comparator.naturalOrder())
                    .get()
        );

        List<String> listMax = new ArrayList<>();
        listMax.add("apple");
        listMax.add("ball");
        listMax.add("cat");
        listMax.add("dog");

        System.out.println(
                listMax.stream()
                        .filter(s -> s.length() > 3)
                        .max(Comparator.naturalOrder())
                        .get()

        );
    }
}
