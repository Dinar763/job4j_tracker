package ru.job4j;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
            .takeWhile(value -> value < 4)
            .map(value -> "Результат: " + value)
            .forEach(System.out::println);
    }
}
