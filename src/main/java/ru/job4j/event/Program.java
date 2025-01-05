package ru.job4j.event;

public class Program {
    public static void fire(Object sender) {
        System.out.println("Fire!!!");
    }

    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);
        //sw.addElectricityListener(x -> System.out.println("Fire"));
        sw.addElectricityListener(Program::fire);

        sw.switchOn();
    }
}
