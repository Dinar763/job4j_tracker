package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}
