package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String value: origin) {
            check.add(value);
        }

        for (String textValue: text) {
            if (!check.contains(textValue)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
