package me.surendra.leetcode.trees.breadth_first_search.post_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode leftTreeNode = invertTree(root.left);
        TreeNode rightTreeNode = invertTree(root.right);
        root.left = rightTreeNode;
        root.right = leftTreeNode;
        return root;
    }

}
