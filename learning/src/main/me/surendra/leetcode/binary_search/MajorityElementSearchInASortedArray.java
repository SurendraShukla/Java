package me.surendra.leetcode.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/">Check If a Number Is Majority Element in a Sorted Array</a>
 */
public class MajorityElementSearchInASortedArray {

    /*
        Time Complexity - O(n log n)
        Space Complexity - 0(n)
     */
    public boolean isMajorityElement(final int[] nums, final int target) {
        final Integer leftIdx = binarySearch(nums, target, true);
        if (leftIdx == null) {
            return false;
        }
        final Integer rightIdx = binarySearch(nums, target, false);
        return (rightIdx - leftIdx) + 1 > nums.length / 2;
    }

    private Integer binarySearch(final int[] nums, final int target, final boolean firstIdx) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        Integer idx = null;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid < 0 || mid >= nums.length) {
                return idx;
            }
            if (nums[mid] == target) {
                if (idx == null) {
                    idx = mid;
                }
                if (firstIdx) {
                    idx = Math.min(idx, mid);
                    right = mid - 1;
                } else {
                    idx = Math.max(idx, mid);
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return idx;
    }

}
