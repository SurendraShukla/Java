package me.surendra.leetcode.trees;


/**
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Convert Sorted Array to Binary Search Tree</a>
 */
public class SortedArrayToBstConvertor {

    /*
        Time complexity : O(n)
        Space complexity: O(log n) - space because the tree is height-balanced.
     */
    public TreeNode sortedArrayToBST(final int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(final int[] nums, final int left, final int right) {
        if (left > right) {
            return null;
        }
        final int mid = (right + left) / 2;
        final TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

}
