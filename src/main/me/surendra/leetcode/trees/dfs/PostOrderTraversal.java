package me.surendra.leetcode.trees.dfs;


import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Traverse the left subtree
 * 3. Traverse the right subtree
 * 2. Visit the root
 *
 * Bottom-up
 */
public class PostOrderTraversal {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> integerList = new ArrayList<>();
        if(root == null) {
            return integerList;
        }
        integerList.addAll(postorderTraversal(root.left)); // Traverse the left subtree
        integerList.addAll(postorderTraversal(root.right)); // Traverse the right subtree
        integerList.add(root.val); // Visit the root
        return integerList;
    }
}
