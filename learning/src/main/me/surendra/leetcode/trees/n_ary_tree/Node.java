package me.surendra.leetcode.trees.n_ary_tree;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() { }

    public Node(final int val) {
        this.val = val;
    }

    public Node(final int val, final List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(final int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(final List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
            "val=" + val +
            ", children=" + children +
            '}';
    }
}

