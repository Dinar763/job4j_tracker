package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по рельсам");
    }

    @Override
    public void getTypeVehicle() {
        System.out.println(getClass().getSimpleName());
    }
}
