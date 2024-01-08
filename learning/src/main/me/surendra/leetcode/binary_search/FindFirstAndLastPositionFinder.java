package me.surendra.leetcode.binary_search;


/**
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
 */
public class FindFirstAndLastPositionFinder {

    /*
        Time Complexity - O(n long n)
        Space Complexity - O(1)
    */
    int[] numArr;
    public int[] searchRange(final int[] nums, final int target) {
        this.numArr = nums;
        final int firstPosition = getPosition(target, true);
        if (firstPosition == nums.length) {
            return new int[]{-1, -1};
        }
        final int lastPosition = getPosition(target, false);
        return new int[]{firstPosition, lastPosition};
    }


    private int getPosition(final int target, final boolean first) {
        int leftMin = numArr.length;
        int rightMax = -1;
        int left = 0;
        int right = numArr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (numArr[mid] == target) {
                if (first) {
                    leftMin = Math.min(leftMin, mid);
                    right = mid - 1;
                } else {
                    rightMax = Math.max(rightMax, mid);
                    left = mid + 1;
                }
            } else if (numArr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first ? leftMin : rightMax;
    }

}
