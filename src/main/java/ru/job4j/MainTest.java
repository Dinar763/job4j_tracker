package ru.job4j;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

public class MainTest {

    public static void main(String[] args) {
        List<String> data = List.of("1", "2", "3", "4");
        System.out.println(join(data));
    }

    public static String join(List<String> strings) {
        return strings.stream()
            .collect(Collectors.joining(System.lineSeparator(), "Prefix", "Suffix"));
    }
}
