package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("History", 100);
        Book book2 = new Book("Algebra", 200);
        Book book3 = new Book("Philosophy", 400);
        Book book4 = new Book("Clean code", 345);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Имя книги: " + books[i].getName()
                + " Количество страниц: " + books[i].getNumberOfPages());
        }
        Book book5 = book1;
        books[0] = books[3];
        books[3] = book5;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Имя книги: " + books[i].getName()
                + " Количество страниц: " + books[i].getNumberOfPages());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println("Имя книги: " + books[i].getName()
                    + " Количество страниц: " + books[i].getNumberOfPages());
            }
        }
    }
}
