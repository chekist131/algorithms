package org.tony.collection.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet implements MySet {

    private static final int hashLength = 16;

    private ArrayList<LinkedList<Integer>> data;
    private int count;

    {
        data = new ArrayList<>(hashLength);
        for (int i = 0; i < hashLength; i++) {
            data.add(new LinkedList<>());
        }
        count = 0;
    }

    @Override
    public void add(int x) {
        LinkedList<Integer> cel = data.get(x % hashLength);
        if (!cel.contains(x)) {
            cel.add(x);
            count++;
        }

    }

    @Override
    public boolean find(int x) {
        LinkedList<Integer> cel = data.get(x % hashLength);
        return cel.contains(x);
    }

    @Override
    public List<Integer> getAll() {
        LinkedList<Integer> result = new LinkedList<>();
        for(LinkedList<Integer> cel: data)
            result.addAll(cel);
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Integer>, Cloneable {

        private int cursorCelIndex;
        private Iterator<Integer> cursorInCelIterator;
        private int cursorCounter;

        {
            cursorCelIndex = 0;
            cursorInCelIterator = data.get(cursorCelIndex).iterator();
            cursorCounter = 0;
        }

        @Override
        public boolean hasNext() {
            return cursorCounter < count;
        }

        @Override
        public Integer next() {
            while (!cursorInCelIterator.hasNext()) {
                cursorCelIndex++;
                cursorInCelIterator = data.get(cursorCelIndex).iterator();
            }
            cursorCounter++;
            return cursorInCelIterator.next();
        }
    }
}
