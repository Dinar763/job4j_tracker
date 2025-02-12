package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == 0) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int val = data[row][column++];
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        return val;
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 2},
            {3, 4}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
