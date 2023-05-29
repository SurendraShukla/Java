package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isValidBST(final TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return isValidBSTUsingNull(root, null, null);
    }

    public boolean isValidBST(final TreeNode root, final long minBound, final long maxBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= minBound || root.val >= maxBound) {
            return false;
        }
        return isValidBST(root.left, minBound, root.val) && isValidBST(root.right, root.val, maxBound);
    }

    public boolean isValidBSTUsingNull(final TreeNode root, final Integer minBound, final Integer maxBound) {
        if (root == null) {
            return true;
        }
        if ((minBound != null && root.val <= minBound) ||
            (maxBound != null && root.val >= maxBound)
        ) {
            return false;
        }
        return isValidBSTUsingNull(root.left, minBound, root.val) && isValidBSTUsingNull(root.right, root.val, maxBound);
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> upperLimits = new LinkedList();
    private Deque<Integer> lowerLimits = new LinkedList();
    public void update(final TreeNode root, final Integer low, final Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBSTUsingIteration(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }


}
