package me.surendra.leetcode.trees.depth_first_search;


import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/subtree-of-another-tree/">Subtree of Another Tree</a>
 */
public class SubtreeOfAnotherTree {

    /*
        Time Complexity - O(m * n) m is the number of nodes in subRoot, n is the number of nodes in root
        Space Complexity - O(m + n)
     */
    public boolean isSubtree(final TreeNode root, final TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(final TreeNode root, final TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return (root.val == subRoot.val) && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

}
