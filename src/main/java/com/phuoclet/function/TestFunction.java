package com.phuoclet.function;

import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        Function<String, Integer> strLen = s -> s.length();
        Function<Integer, Integer> square = integer -> integer * integer;

        System.out.println(
                strLen.andThen(square).apply("Hi Hello How are you")
                // andthen a.andthen(b) => a -> b
                // compose a.compose(b) => b -> a
        );
    }
}
