package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutPut;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutPut();
        Input input = new MockInput(
            new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
            new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item")); /* Добавляется в tracker новая заявка */
        Input input = new MockInput(
            new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenFindAllActionTestIsSuccesfully() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input input = new MockInput(
            new String[] {"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
        "Меню:" + ln
            + "0. Показать все заявки" + ln
            + "1. Завершить программу" + ln
            + "=== Список всех заявок ===" + ln
            + one + ln
            + two + ln
            + "Меню:" + ln
            + "0. Показать все заявки" + ln
            + "1. Завершить программу" + ln
            + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameActionIsSuccessfully() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
            new String[] {"0", one.getName(), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
            "Меню:" + ln
                + "0. Показать заявки по имени" + ln
                + "1. Завершить программу" + ln
                + "=== Вывод заявок по имени ===" + ln
                + one + ln
                + "Меню:" + ln
                + "0. Показать заявки по имени" + ln
                + "1. Завершить программу" + ln
                + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdActionIsSuccessfully() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
            new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
            "Меню:" + ln
                + "0. Показать заявку по id" + ln
                + "1. Завершить программу" + ln
                + "=== Вывод заявки по id ===" + ln
                + one + ln
                + "Меню:" + ln
                + "0. Показать заявку по id" + ln
                + "1. Завершить программу" + ln
                + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
            new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
            "Меню:" + ln
                + "0. Изменить заявку" + ln
                + "1. Завершить программу" + ln
                + "=== Редактирование заявки ===" + ln
                + "Заявка изменена успешно." + ln
                + "Меню:" + ln
                + "0. Изменить заявку" + ln
                + "1. Завершить программу" + ln
                + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutPut();
        Input input = new MockInput(
            new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
            "Меню:" + ln
                + "0. Завершить программу" + ln
                + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                + "Меню:" + ln
                + "0. Завершить программу" + ln
                + "=== Завершение программы ===" + ln
        );
    }
}