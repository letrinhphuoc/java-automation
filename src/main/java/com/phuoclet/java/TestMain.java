package com.phuoclet.java;

import com.phuoclet.java.interfacepolymorphism.Alarm;
import com.phuoclet.java.interfacepolymorphism.Clock;
import com.phuoclet.java.interfacepolymorphism.GoogleMini;
import com.phuoclet.java.interfacepolymorphism.Iphone;
import com.phuoclet.java.lambda.GreetingService;
import com.phuoclet.java.polymorphism.*;

public class TestMain {
    public static void main(String[] args) {
        GreetingService helloService = (firstName, lastName, age) -> {
            System.out.println("My name :: " + firstName + " " + lastName);
            System.out.println("My age :: " + age);
        };

        helloService.greet("James", "Lee", 30);
    }

}
