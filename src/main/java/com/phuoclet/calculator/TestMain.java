package com.phuoclet.calculator;

public class TestMain {
    public static void main(String[] args) {

        // Define the behavior
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract =(a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        // passing the behavior
        int onScreenNumber = 0;
        onScreenNumber = calculate(5, add,2);
        onScreenNumber = calculate(onScreenNumber, subtract, 3);
        onScreenNumber = calculate(onScreenNumber, multiply, 7);
        onScreenNumber = calculate(onScreenNumber, add, 2);
        onScreenNumber = calculate(onScreenNumber, divide, 3);
        System.out.println(onScreenNumber);
    }

    private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber){
        // has the data
        return  mathOperation.operate(onScreenNumber,enteredNumber);
    }
}
