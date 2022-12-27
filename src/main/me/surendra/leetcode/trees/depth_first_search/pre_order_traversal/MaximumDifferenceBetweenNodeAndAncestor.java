package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">Maximum Difference Between Node and Ancestor</a>
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    int result = 0;
    public int maxAncestorDiff(final TreeNode root) {
        populate(root, root.val, root.val);
        return result;
    }

    private void populate(final TreeNode root, int maxVal, int minVal) {
        if (root == null) {
            return;
        }
        result = Math.max(result, maxVal - root.val);
        result = Math.max(result, Math.abs(minVal - root.val));

        maxVal = Math.max(maxVal, root.val);
        minVal = Math.min(minVal, root.val);

        populate(root.left, maxVal, minVal);
        populate(root.right, maxVal, minVal);
    }

}
