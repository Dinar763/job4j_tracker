package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ItemSortedTest {

    @Test
    public void whenSortedAscByName() {
        List<Item> items = Arrays.asList(
            new Item("Window"),
            new Item("User"),
            new Item("Fox"),
            new Item("Bob"),
            new Item("Apple")
        );
        List<Item> itemsExpected = Arrays.asList(
            new Item("Apple"),
            new Item("Bob"),
            new Item("Fox"),
            new Item("User"),
            new Item("Window")
            );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(itemsExpected);
    }

    @Test
    public void whenSortedDescByName() {
        List<Item> items = Arrays.asList(
            new Item("Window"),
            new Item("User"),
            new Item("Fox"),
            new Item("Bob"),
            new Item("Apple")
        );
        List<Item> itemsExpected = Arrays.asList(
            new Item("Window"),
            new Item("User"),
            new Item("Fox"),
            new Item("Bob"),
            new Item("Apple")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(itemsExpected);
    }
}