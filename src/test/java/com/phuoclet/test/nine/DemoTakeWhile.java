package com.phuoclet.test.nine;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoTakeWhile {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(4,2,1,4,5,2,1,1,2,3,5,2,1,0);

//        System.out.println(
//                numbers
//                        .filter(integer -> integer < 5)
//                        .collect(Collectors.toList())
//        );
        // Using take while: if the condition not true, it will not do anything and it exits
//        System.out.println(
//                numbers
//                        .takeWhile(integer -> integer < 5)
//                        .collect(Collectors.toList())
//        );
    }
}
