package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 */
public class RangeSumFinder {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        populate(root, low, high);
        return sum;
    }

    public void populate(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val > low) {
            populate(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum+=root.val;
        }
        if (root.val < high) {
            populate(root.right, low, high);
        }
    }

}
