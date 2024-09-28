package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        switch (position) {
            case (1):
                System.out.println("Пусть бегут неуклюже пешеходы по лужам");
                break;
            case (2):
                System.out.println("Спят усталые ребята книжки спят");
                break;
            default:
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox juke = new Jukebox();
        juke.music(1);
        juke.music(2);
        juke.music(3);
    }
}
