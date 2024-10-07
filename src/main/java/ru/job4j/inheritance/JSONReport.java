package ru.job4j.inheritance;

/** @noinspection checkstyle:WhitespaceAround*/
public class JSONReport extends TextReport {

    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{" + ln
            + "\t\"name\" : " + "\"" +  name + "\"" + "," + ln
            + "\t\"body\" : " + "\"" + body + "\"" + ln
            + "}";
    }
}
