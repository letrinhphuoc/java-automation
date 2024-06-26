package com.phuoclet.compare;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        Student a = new Student("Adam", 80, 150);
        Student b = new Student("Bob", 96, 123);
        Student c = new Student("Carl", 75, 135);

        Optional<Student> minScore = Stream.of(a, b, c)
                .min(Comparator.comparing(student -> student.getScore()));

        Optional<Student> maxScore = Stream.of(a, b, c)
                .max(Comparator.comparing(student -> student.getScore()));

        System.out.println(minScore.get());
        System.out.println(maxScore.get());
    }
}
