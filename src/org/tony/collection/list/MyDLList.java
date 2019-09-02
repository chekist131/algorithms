package org.tony.collection.list;

import java.util.Iterator;

public class MyDLList implements MyDequeue {

    private MyDLLNode left;
    private MyDLLNode right;

    @Override
    public void pushRight(int x) {
        if (this.left == null) {
            this.left = this.right = new MyDLLNode(x, null, null);
        } else {
            MyDLLNode oldRight = this.right;
            this.right = new MyDLLNode(x, oldRight, null);
            oldRight.setRight(this.right);
        }
    }

    @Override
    public int popLeft() {
        int value = left.getValue();
        if (left == right) {
            left = right = null;
        } else {
            left = left.getRight();
            left.setLeft(null);
        }
        return value;
    }

    @Override
    public void pushLeft(int x) {
        if (this.left == null) {
            this.left = this.right = new MyDLLNode(x, null, null);
        } else {
            MyDLLNode oldLeft = this.left;
            this.left = new MyDLLNode(x, null, oldLeft);
            oldLeft.setLeft(this.left);
        }
    }

    @Override
    public int popRight() {
        int value = right.getValue();
        if (left == right) {
            left = right = null;
        } else {
            right = right.getLeft();
            right.setRight(null);
        }
        return value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyDLLListIterator();
    }

    @Override
    public void add(int x) {
        this.pushLeft(x);
    }

    private class MyDLLListIterator implements Iterator<Integer> {

        private MyDLLNode cursor;

        {
            cursor = left;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Integer next() {
            int value = cursor.getValue();
            cursor = cursor.getRight();
            return value;
        }
    }

    private static class MyDLLNode {
        private int value;
        private MyDLLNode left;
        private MyDLLNode right;

        private MyDLLNode(int value, MyDLLNode left, MyDLLNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private MyDLLNode getLeft() {
            return left;
        }

        private void setLeft(MyDLLNode left) {
            this.left = left;
        }

        private MyDLLNode getRight() {
            return right;
        }

        private void setRight(MyDLLNode right) {
            this.right = right;
        }
    }
}
