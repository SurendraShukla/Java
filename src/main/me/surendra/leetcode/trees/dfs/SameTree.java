package me.surendra.leetcode.trees.dfs;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 */
public class SameTree {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }

}
