package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-average-subtree/">Maximum Average Subtree</a>
 */
public class MaximumAverageSubtree {

    /*
        Time Complexity - O(n) Whole tree traverse
        Space Complexity - O(n) Recursion call stack
     */
    double maxAverage = 0;
    public double maximumAverageSubtree(final TreeNode root) {
        populate(root);

        return maxAverage;
    }

    int[] populate(final TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        final int[] leftTree = populate(root.left);
        final int[] rightTree = populate(root.right);

        final int[] result = {0, 0};
        result[0] = 1 + leftTree[0] + rightTree[0];
        result[1] = root.val + leftTree[1] + rightTree[1];

        maxAverage = Math.max(maxAverage, (result[1] * 1.0) / result[0]);
        return result;
    }

}
