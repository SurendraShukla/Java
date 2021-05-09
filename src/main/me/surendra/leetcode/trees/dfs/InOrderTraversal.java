package me.surendra.leetcode.trees.dfs;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Traverse the left subtree
 * 2. Visit the root first.
 * 3. Traverse the right subtree
 */
public class InOrderTraversal {

    final List<Integer> integerList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return integerList;
        }
        inorderTraversal(root.left);
        integerList.add(root.val);
        inorderTraversal(root.right);
        return integerList;
    }

}
