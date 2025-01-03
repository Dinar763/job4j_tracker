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
            if (value.getPhone().contains(key) || value.getName().contains(key)
            || value.getSurname().contains(key) || value.getAddress().contains(key)) {
                result.add(value);
            }
        }
        return result;
    }
}
