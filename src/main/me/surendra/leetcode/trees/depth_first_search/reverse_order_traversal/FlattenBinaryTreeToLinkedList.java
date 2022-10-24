package me.surendra.leetcode.trees.depth_first_search.reverse_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.Stack;


/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 */
public class FlattenBinaryTreeToLinkedList {

    /*
        Time Complexity - O(n) Whole tree traverse
        Space Complexity - O(n) Recursion call stack
     */
    TreeNode previousNode = null;
    public void flatten(final TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = previousNode;
        previousNode = root;
    }

}
