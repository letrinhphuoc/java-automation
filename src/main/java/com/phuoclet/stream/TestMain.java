package com.phuoclet.stream;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println("starting");
//        list.stream()
//                .filter(i -> {
//                    System.out.println("filter-received :: " + i);
//                    return i % 2 == 0;
//                })
//                .sorted()
//                .limit(3)
//                .map(i -> {
//                    System.out.println("map - received :: " + i);
//                    return i * i;
//                })
//                .forEach(i -> System.out.println(i));
//        list.stream()
//            .peek(i -> System.out.println("filter-received :: " + i))
//            .filter(i -> i % 2 == 0)
//            .limit(3)
//            .peek(i -> System.out.println("map-received :: " + i))
//            .map(i -> i * i)
//            .skip(2) // 36
//            .forEach(i -> System.out.println(i));

        // check for even numbers
        // ensure that number > 5
        // find the square and 2 to that
        // print it on the console one by one - new line
        list.stream()
                .peek(i -> System.out.println("filter-received :: " + i))
                .filter(i -> i % 2 == 0)
                .filter(i -> i > 5)
                .peek(i -> System.out.println("map-received :: " + i))
                .map(i -> i * i)
                .map(i -> i + 2)
                .forEach(i -> System.out.println(i));
        System.out.println("ending");
    }
}
