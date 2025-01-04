package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surNamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);
        Predicate<Person> combine = phonePredicate.or(namePredicate.or(surNamePredicate.or(addressPredicate)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (combine.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
