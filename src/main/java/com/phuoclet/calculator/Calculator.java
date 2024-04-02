package com.phuoclet.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    // Create a map
    private static final Map<String, MathOperation> map = new HashMap<>();

    // We stored all the operations
    static {
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);
    }
    public static  void addOperation(String key, MathOperation mathOperation){
        map.put(key, mathOperation);
    }

    public static int calculate(String expression){
        String[] exps = expression.split(" ");
        int onScreenNumber = Integer.parseInt(exps[0]);
        for (int i = 1; i < exps.length ; i = i + 2) {
           MathOperation op = map.get(exps[i]);
           int enteredNunber = Integer.parseInt(exps[i + 1]);
           onScreenNumber = calculate(onScreenNumber, op, enteredNunber);
        }
        return onScreenNumber;
    }

    private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber){
        // has the data
        return  mathOperation.operate(onScreenNumber,enteredNumber);
    }
}
