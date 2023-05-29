package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">Kth Smallest Element in a BST</a>
 */
public class KthSmallestElementInBSTFinder {

    /*
        Time complexity : O(n) All nodes search
        Space complexity: O(n) Recursion stack
     */
    Integer kthNumber = null;
    int foundCounter = 0;
    public int kthSmallest(final TreeNode root, final int k) {
        populate(root, k);
        return kthNumber.intValue();
    }

    private void populate(final TreeNode root, final int k) {
        if (root == null || foundCounter >= k) {
            return;
        }
        populate(root.left, k);
        foundCounter++;
        if (foundCounter == k) {
            kthNumber = root.val;
        }
        populate(root.right, k);
    }

}
