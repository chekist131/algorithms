package org.tony.collection.list;

import java.util.Iterator;

public class MyLList implements MyList, MyStack {

    private LLNode data;

    @Override
    public void add(int x) {
        this.data = add(x, this.data);
    }

    @Override
    public int pop() {
        int value = this.data.getValue();
        this.data = this.data.getNext();
        return value;
    }

    private static LLNode add(int x, LLNode node) {
        if (node == null) {
            return new LLNode(x, null);
        } else {
            return new LLNode(x, node);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {

        private LLNode cursor;

        {
            cursor = data;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Integer next() {
            int value = cursor.getValue();
            cursor = cursor.getNext();
            return value;
        }
    }

    private static class LLNode {
        private int value;
        private LLNode next;

        private LLNode(int value, LLNode next) {
            this.value = value;
            this.next = next;
        }

        private int getValue() {
            return value;
        }

        private LLNode getNext() {
            return next;
        }
    }

}
