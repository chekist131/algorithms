package org.tony.collection.set;

import java.util.List;

public class TreeNode {

    private int value;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public TreeNode(int value, TreeNode leftTreeNode, TreeNode rightTreeNode) {
        this.value = value;
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public static TreeNode pushTreeNode(int x, TreeNode treeNode) {
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

    public static boolean findTreeNode(int x, TreeNode treeNode) {
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

    public static void getAllFromLessRecursive(TreeNode treeNode, List<Integer> items) {
        if (treeNode != null) {
            getAllFromLessRecursive(treeNode.getLeftTreeNode(), items);
            items.add(treeNode.getValue());
            getAllFromLessRecursive(treeNode.getRightTreeNode(), items);
        }
    }
}
