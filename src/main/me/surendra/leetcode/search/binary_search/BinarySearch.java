package me.surendra.leetcode.search.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/binary-search/">Binary Search</a>
 */
public class BinarySearch {

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(1)
     */
    public int search(final int[] nums, final int target) {
        int low = 0;
        int max = nums.length - 1;

        while (low <= max) {
            final int mid = ((max - low) / 2) + low;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                max = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
