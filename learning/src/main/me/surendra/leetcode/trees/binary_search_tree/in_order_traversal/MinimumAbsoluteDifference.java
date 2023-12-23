package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/">Minimum Absolute Difference in BST</a>
 */
public class MinimumAbsoluteDifference {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    Integer preVal;
    int minAbsoluteDifference = Integer.MAX_VALUE;
    public int getMinimumDifference(final TreeNode root) {
        populate(root);
        return minAbsoluteDifference;
    }

    private void populate(final TreeNode root) {
        if (root == null) {
            return;
        }
        populate(root.left);
        if (preVal != null) {
            minAbsoluteDifference = Math.min(minAbsoluteDifference, root.val - preVal);
        }
        preVal = root.val;
        populate(root.right);
    }

}
