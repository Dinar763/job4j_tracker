package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("petrov@mail.ru", "Петров Петр Петрович");
        map.put("ivanov@mail.ru", "Ivanov Петр Петрович");
        map.put("ivanov@mail.ru", "Efimov Петр Петрович");
        map.put("ionov@mail.ru", "Ionov Петр Петрович");
        for (Map.Entry<String, String> entry: map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
