package me.surendra.leetcode.trees;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() { }

    public Node(final int val) {
        this.val = val;
    }

    public Node(final int val, final Node left, final Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = null;
    }
    public Node(final int val, final Node left, final Node right, final Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(final int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }

}

