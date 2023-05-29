package me.surendra.leetcode.search.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element</a>
 */
public class PeakElementFinder {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public int findPeakElementUsingBinarySearch(int[] nums) {
        return 1;
    }

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public int findPeakElementByComparingNextValueOnly(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public int findPeakElementByBothSideValues(int[] nums) {
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (isPeakElement(nums, length, i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPeakElement(final int[] nums, final int length, final int currentIdx) {
        int leftIndex = currentIdx-1;
        int rightIndex = currentIdx+1;
        if (leftIndex > 0 && nums[currentIdx] < nums[leftIndex]) {
            return false;
        }
        if (rightIndex < length && nums[currentIdx] < nums[rightIndex]) {
            return false;
        }
        return true;
    }

}
