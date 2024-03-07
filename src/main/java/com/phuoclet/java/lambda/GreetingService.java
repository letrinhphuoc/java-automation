package com.phuoclet.java.lambda;
@FunctionalInterface
public interface GreetingService {
    // SAM - single abstract method
    void greet(String firstName, String lastName, int age);
}
