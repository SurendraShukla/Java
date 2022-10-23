package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 */
public class SameTree {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isSameTree(final TreeNode left, final TreeNode right) {
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
