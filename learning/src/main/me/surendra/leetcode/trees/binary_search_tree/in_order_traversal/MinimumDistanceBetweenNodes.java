package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Minimum Distance Between BST Nodes</a>
 */
public class MinimumDistanceBetweenNodes {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    int minDifference = Integer.MAX_VALUE;
    int previousVal = Integer.MAX_VALUE;
    public int minDiffInBST(final TreeNode root) {
        populate(root);
        return minDifference;
    }

    private void populate(final TreeNode root) {
        if (root == null) {
            return;
        }
        populate(root.left);
        minDifference = Math.min(minDifference, Math.abs(root.val - previousVal));
        previousVal = root.val;
        populate(root.right);
    }

}
