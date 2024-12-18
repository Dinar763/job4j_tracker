package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Str = o1.split("\\.");
        String[] o2Str = o2.split("\\.");
        String o1StrVal = o1Str[0].trim();
        String o2StrVal = o2Str[0].trim();
        return Integer.compare(Integer.parseInt(o1StrVal), Integer.parseInt(o2StrVal));
    }

    public static void main(String[] args) {
        String[] input = {
            "10. Task.",
            "1. Task.",
            "2. Task."
        };
        Arrays.sort(input, new LexSort());
        for (String val: input) {
            System.out.println(val);
        }
    }
}
