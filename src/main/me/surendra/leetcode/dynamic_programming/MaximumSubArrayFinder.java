package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 */
public class MaximumSubArrayFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxSubArrayUsingJosephKadaneAlgo(final int[] nums) {
        int maxSubArray = nums[0];
        int currentMaxSubArray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMaxSubArray = Math.max(nums[i], currentMaxSubArray + nums[i]);
            maxSubArray = Math.max(maxSubArray, currentMaxSubArray);
        }
        return maxSubArray;
    }

    public int maxSubArrayUsingBruteForceAlgo(final int[] nums) {
        return 0;
    }

}
