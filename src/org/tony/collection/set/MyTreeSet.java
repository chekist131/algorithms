package org.tony.collection.set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MyTreeSet implements MySet {

    private TreeNode treeNode;

    @Override
    public void add(int x) {
        this.treeNode = TreeNode.pushTreeNode(x, this.treeNode);
    }

    @Override
    public boolean find(int x) {
        return TreeNode.findTreeNode(x, this.treeNode);
    }

    @Override
    public List<Integer> getAll() {
        final List<Integer> items = new LinkedList<>();
        TreeNode.getAllFromLess(treeNode, items);
        return items;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private Stack<TreeNode> stack;
            private TreeNode cursor;

            {
                stack = new Stack<>();
                cursor = MyTreeSet.this.treeNode;
            }

            @Override
            public boolean hasNext() {
                return (!stack.isEmpty() || cursor != null);
            }

            @Override
            public Integer next() {
                while (cursor != null) {
                    stack.push(cursor);
                    cursor = cursor.getLeftTreeNode();
                }
                cursor = stack.pop();
                int value = cursor.getValue();
                cursor = cursor.getRightTreeNode();
                return value;
            }
        };
    }

    private static class TreeNode {

        private int value;
        private TreeNode leftTreeNode;
        private TreeNode rightTreeNode;

        private TreeNode(int value, TreeNode leftTreeNode, TreeNode rightTreeNode) {
            this.value = value;
            this.leftTreeNode = leftTreeNode;
            this.rightTreeNode = rightTreeNode;
        }

        private int getValue() {
            return value;
        }

        private TreeNode getLeftTreeNode() {
            return leftTreeNode;
        }

        private TreeNode getRightTreeNode() {
            return rightTreeNode;
        }

        private static TreeNode pushTreeNode(int x, TreeNode treeNode) {
            if (treeNode == null) {
                return new TreeNode(x, null, null);
            } else if (x == treeNode.getValue()) {
                return treeNode;
            } else {
                if (x < treeNode.getValue()) {
                    return new TreeNode(
                            treeNode.getValue(),
                            pushTreeNode(x, treeNode.getLeftTreeNode()),
                            treeNode.getRightTreeNode());
                } else {
                    return new TreeNode(
                            treeNode.getValue(),
                            treeNode.getLeftTreeNode(),
                            pushTreeNode(x, treeNode.getRightTreeNode())
                    );
                }
            }
        }

        private static boolean findTreeNode(int x, TreeNode treeNode) {
            if (treeNode == null) {
                return false;
            } else if (x == treeNode.getValue()) {
                return true;
            } else if (x < treeNode.getValue()) {
                return findTreeNode(x, treeNode.getLeftTreeNode());
            } else {
                return findTreeNode(x, treeNode.getRightTreeNode());
            }
        }

        private static void getAllFromLess(TreeNode treeNode, List<Integer> items) {
            if (treeNode != null) {
                getAllFromLess(treeNode.getLeftTreeNode(), items);
                items.add(treeNode.getValue());
                getAllFromLess(treeNode.getRightTreeNode(), items);
            }
        }
    }
}
