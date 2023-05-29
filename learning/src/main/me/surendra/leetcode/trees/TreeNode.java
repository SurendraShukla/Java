package me.surendra.leetcode.trees;

import com.google.common.base.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        final TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equal(left, treeNode.left) && Objects.equal(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
