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
        return getEvenIndex() != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int neededIndex = getEvenIndex();
        index = neededIndex + 1;
        return data[neededIndex];
    }

    public Integer getEvenIndex() {
        int evenIndex = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                evenIndex = i;
                break;
            }
        }
        return evenIndex;
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = new EvenNumbersIterator(new int[] {1, -3, 2, 3, 5, 5, -4, 5, 6, 7});
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
