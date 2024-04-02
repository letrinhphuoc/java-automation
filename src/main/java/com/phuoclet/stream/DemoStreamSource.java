package com.phuoclet.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class DemoStreamSource {
    public static void main(String[] args) {
        String a = "Ball";
        String b = "Detal";
        String c = "Apple";

        System.out.println(

                Stream.of(a,b,c)
                        .min(Comparator.naturalOrder())
                        .get()

        );
    }
}
