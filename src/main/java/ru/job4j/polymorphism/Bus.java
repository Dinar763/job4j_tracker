package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Я еду с помощью крутящихся колес");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров - 80");
    }

    @Override
    public int refuel(int fuel) {
        return 65;
    }
}
