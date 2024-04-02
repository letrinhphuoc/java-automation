package com.phuoclet.assessment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstNameAssignment {
    public static void main(String[] args) throws IOException {
        //test.txt
        Path path = Paths.get("test.txt");
        List<String> list = Files.readAllLines(path);

        // Print the count of names which start with B
        System.out.println(
                list.stream()
                        .filter(name -> name.startsWith("B"))
                        .count()
        );
        // Create a list of names with start with C and contains 's' in it
        List<String> collect = list.stream()
                .filter(name -> name.startsWith("C"))
                .filter(name -> name.toLowerCase().contains("s"))
                .collect(Collectors.toList());
        System.out.println(collect.size());
        // Print the total number of chars for all the name starting with M
        System.out.println(
                list.stream()
                        .filter(name -> name.startsWith("M"))
                        .map(String::trim)
                        .map(String::length)
                        .mapToInt(i -> i)
                        .sum()
        );

        // Jo-Ann => Jo Ann
        // Find the names containing - in it and replace it with a space; collect them into a list
        System.out.println(
                list.stream()
                        .filter(name -> name.contains("-"))
                        .map(name -> name.replaceAll("-"," "))
                        .collect(Collectors.toList())
        );

        // Find the name which has more number of chars
        System.out.println(
                list.stream()
                        .max(Comparator.comparing(s -> s.length()))
                        .get()
        );

    }
}
