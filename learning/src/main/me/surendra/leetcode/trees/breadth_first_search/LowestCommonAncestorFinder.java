package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">Lowest Common Ancestor of a Binary Tree</a>
 */
public class LowestCommonAncestorFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

}
