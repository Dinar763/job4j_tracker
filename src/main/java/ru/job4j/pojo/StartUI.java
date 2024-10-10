package ru.job4j.pojo;

import ru.job4j.tracker.Item;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item(12, "First");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getCreated().format(formatter);
        System.out.println(currentDateTimeFormat);
    }
}
