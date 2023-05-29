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
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> integerList = new ArrayList<>();
        if(root == null) {
            return integerList;
        }
        integerList.addAll(inorderTraversal(root.left)); // Traverse the left subtree
        integerList.add(root.val); // Visit the root
        integerList.addAll(inorderTraversal(root.right)); // Traverse the right subtree
        return integerList;
    }

}
