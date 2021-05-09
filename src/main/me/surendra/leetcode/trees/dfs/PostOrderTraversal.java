package me.surendra.leetcode.trees.dfs;


import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Traverse the left subtree
 * 3. Traverse the right subtree
 * 2. Visit the root first.
 */
public class PostOrderTraversal {
    final List<Integer> integerList = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return integerList;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        integerList.add(root.val);
        return integerList;
    }
}
