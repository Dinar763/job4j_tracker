package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void getTypeVehicle() {
        System.out.println(getClass().getSimpleName());
    }
}
