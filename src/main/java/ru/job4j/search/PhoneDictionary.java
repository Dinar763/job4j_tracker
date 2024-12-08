package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            StringBuilder findValue = new StringBuilder(value.getName() + value.getAddress()
                + value.getSurname() + value.getPhone());
            if (findValue.toString().contains(key)) {
                result.add(value);
            }
            findValue.delete(0, findValue.toString().length());
        }
        return result;
    }
}
