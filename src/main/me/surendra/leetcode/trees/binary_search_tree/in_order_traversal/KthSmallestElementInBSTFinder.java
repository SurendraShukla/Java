package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 */
public class KthSmallestElementInBSTFinder {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    Integer kthNumber = null;
    public int kthSmallest(TreeNode root, int k) {
        populate(root, k);
        return kthNumber.intValue();
    }

    void populate(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        populate(root.left, k);
        if (kthNumber != null) {
            return;
        }
        if (--k == 0) {
            kthNumber = root.val;
            return;
        }
        populate(root.right, k);
    }

}
