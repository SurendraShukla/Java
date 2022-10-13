package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 */
public class PathSumFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean hasPathSumUsingRecursion(final TreeNode root, final int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSumUsingRecursion(root.left, targetSum - root.val)
            || hasPathSumUsingRecursion(root.right, targetSum - root.val);
    }


    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean hasPathSumUsingRecursionAndAdditionAtEachLevel(final TreeNode root, final int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, root.val);
    }

    public boolean hasPathSum(final TreeNode root, final int targetSum, final int levelSum) {
        if (root.left == null && root.right == null) {
            return targetSum == levelSum;
        }
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum, levelSum + root.left.val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum, levelSum + root.right.val)) {
                return true;
            }
        }
        return false;
    }

}
