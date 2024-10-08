package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(
            first,
            add(second, third)
        );
    }

    public static int minus(int number) {
        return number - x;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);
        int result2 = minus(15);
        System.out.println(result2);
        int result3 = calculator.divide(25);
        System.out.println(result3);
        int result4 = calculator.sumAllOperation(25);
        System.out.println(result4);
    }
}
