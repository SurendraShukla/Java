package me.surendra.leetcode.trees;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isValidBST(final TreeNode root) {
        return isValidBSTUsingNull(root, null, null);
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
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


}
