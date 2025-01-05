package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 3, -5, -22, 112, 115, 0, 3, 5, -6);
        List<Integer> positive = numbers.stream().filter(val -> val > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
