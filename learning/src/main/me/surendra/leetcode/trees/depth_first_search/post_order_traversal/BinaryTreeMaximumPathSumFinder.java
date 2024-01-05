package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
 */
public class BinaryTreeMaximumPathSumFinder {

    /*
        Time Complexity - O(n) Whole tree traverse
        Space Complexity - O(n) Recursion call stack
     */
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(final TreeNode root) {
        maxGain(root);
//        populate(root);
        return maxSum;
    }

    public int maxGain(final TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        final int leftGain = Math.max(maxGain(node.left), 0);
        final int rightGain = Math.max(maxGain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        final int priceNewPath = node.val + leftGain + rightGain;

        // update max_sum if it's better to start a new path
        maxSum = Math.max(maxSum, priceNewPath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(leftGain, rightGain);
    }


    int populate(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int left = populate(root.left);
        final int right = populate(root.right);

        final int leftSum = left + root.val;
        final int rightSum = right + root.val;
        final int totalSum = left + right + root.val;

        final int leftRightMax = Math.max(leftSum, rightSum);
        final int sumMax = Math.max(leftRightMax, totalSum);
        final int currentSum = Math.max(sumMax, root.val);

        maxSum = Math.max(maxSum, currentSum);

        return Math.max(Math.max(leftSum, rightSum), root.val);
    }

}
