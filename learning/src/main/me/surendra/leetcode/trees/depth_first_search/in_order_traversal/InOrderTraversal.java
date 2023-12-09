package me.surendra.leetcode.trees.depth_first_search.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder Traversal</a>
 *
 * 1. Traverse the left subtree
 * 2. Visit the root
 * 3. Traverse the right subtree
 */
public class InOrderTraversal {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    final List<Integer> integerList = new ArrayList<>();
    public List<Integer> inorderTraversal(final TreeNode root) {
        populate(root);
        return integerList;
    }

    private void populate(final TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);    // Traverse the left subtree
        integerList.add(root.val);      // Visit the root
        inorderTraversal(root.right);   // Traverse the right subtree
    }

}
