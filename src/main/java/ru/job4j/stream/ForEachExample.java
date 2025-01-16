package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        String result = strings
            .stream()
            .skip(3)
            .findFirst()
            .orElse("По умолчанию");
        System.out.println(result);
    }
}