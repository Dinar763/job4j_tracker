package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по дороге");
    }

    @Override
    public void getTypeVehicle() {
        System.out.println(getClass().getSimpleName());
    }
}
