package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public TreeNode invertTree(final TreeNode root) {
        if (root == null) return null;
        final TreeNode leftTreeNode = invertTree(root.left);
        final TreeNode rightTreeNode = invertTree(root.right);
        root.left = rightTreeNode;
        root.right = leftTreeNode;
        return root;
    }

}
