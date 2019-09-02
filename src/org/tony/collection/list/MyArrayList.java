package org.tony.collection.list;

import java.util.Iterator;

public class MyArrayList implements MyStack, MyIndexedList {

    private static final int initialCapacity = 16;

    private int[] data = new int[initialCapacity];
    private int top = -1;

    @Override
    public int pop() {
        return data[top--];
    }

    @Override
    public void add(int x) {
        top++;
        if (top == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[top] = x;
    }

    @Override
    public int get(int i) {
        return data[i];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {

        private int cursor;

        {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor - 1 < top;
        }

        @Override
        public Integer next() {
            cursor++;
            return data[cursor - 1];
        }
    }
}
