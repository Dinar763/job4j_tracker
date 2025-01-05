package ru.job4j.event;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Играет радио");
    }

    @Override
    public void electricityOn(Object sender) {
        playMusic();
    }
}
