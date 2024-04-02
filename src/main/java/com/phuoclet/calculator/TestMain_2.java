package com.phuoclet.calculator;

public class TestMain_2 {
    public static void main(String[] args) {
//        String exp = "5 + 2 - 3 * 7 + 2 / 3";
//        String exp = "10 / 2 * 3 - 3 / 3 * 5";
//        String exp = "9 * 9 - 1 * 7 / 8 + 30";
//        String exp = "9 * 9 - 1 * 7 / 8 + 30 ^ 2";
        String exp = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3";
        Calculator.addOperation("^", ((a, b) -> (int) Math.pow(a,b)));
        Calculator.addOperation("%", ((a, b) -> a % b));
        System.out.println(

                Calculator.calculate(exp)
        );
    }
}
