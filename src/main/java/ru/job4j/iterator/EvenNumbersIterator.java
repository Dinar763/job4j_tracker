package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean flag = false;
        while (index < data.length && !isEven(data[index])) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public boolean isEven(int val) {
        return val % 2 == 0;
    }

    public static void main(String[] args) {
        Iterator<Integer>  iterator = new EvenNumbersIterator(new int[] {1, -3, 3, 5, 5, -4, 5, 7});
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
