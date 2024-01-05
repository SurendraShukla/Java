package me.surendra.leetcode.dynamic_programming.one_d;


import java.util.Arrays;


/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 */
public class LongestIncreasingSubsequence {

    /*
        Time Complexity - O(n * n)
        Space Complexity - O(n)
     */
    public int lengthOfLIS(final int[] nums) {
        int result = 1;
        final int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    cache[i] = Math.max(cache[i], cache[j] + 1);
                }
            }
            result = Math.max(result, cache[i]);
        }
        return result;
    }

}
