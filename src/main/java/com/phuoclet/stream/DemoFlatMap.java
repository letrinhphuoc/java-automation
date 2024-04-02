package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.List;

public class DemoFlatMap {
    //flatMap -> if you give me a list, I want to take all the data within that list
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);

        List<Integer> c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);

        List<List<Integer>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        list.stream()
                .flatMap(l -> l.stream())
                .map(i -> i * i)
                .forEach(System.out::println);
    }
}
