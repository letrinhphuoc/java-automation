package com.phuoclet.stream;

import java.util.*;

public class DemoReduceSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = 0;

        for (int i : list){
            sum = sum + i;
        }
        System.out.println("here is the sum :: " + sum);

        Optional<Integer> reduce = list.stream()
                .reduce((a, b) -> {
                    System.out.println(a + "::" + b);
                    return a + b;
                });

        System.out.println(reduce.get());


    }
}
