package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 */
public class RangeSumFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    int sum = 0;
    int rangeLow;
    int rangeHigh;
    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        this.rangeLow = low;
        this.rangeHigh = high;
        populate(root);
        return sum;
    }

    private void populate(final TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val > rangeLow) {
            populate(root.left);
        }
        if (root.val >= rangeLow && root.val <= rangeHigh) {
            sum += root.val;
        }
        if (root.val < rangeHigh) {
            populate(root.right);
        }
    }

}
