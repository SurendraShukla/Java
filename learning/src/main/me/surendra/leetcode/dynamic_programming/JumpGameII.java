package me.surendra.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * @see <a hrf="https://leetcode.com/problems/jump-game-ii/">Jump Game II</a>
 */
public class JumpGameII {
    int[] cache;
    public int jumpUsingRecursion(final int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, Integer.MAX_VALUE);

        return populateResult(nums, 0);
    }

    private int populateResult(final int[] nums, final int index) {
        if (index >= nums.length - 1) {
            return Integer.MAX_VALUE;
        }
        if (index == nums.length - 1) {
            return 0;
        }
        if (cache[index] != Integer.MAX_VALUE) {
            return cache[index];
        }
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            minVal = Math.min(minVal, populateResult(nums, index + i));
        }

        cache[index] = minVal + 1;
        return cache[index];
    }

    /*
        Time Complexity - O(n ^ 2) = O(n*(n-1)/2)
        Space Complexity - 0(1)
     */
    public int jump(final int[] nums) {
        final int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;

        int minJumpNeeded = Integer.MAX_VALUE;
        final int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {

            final int indexes = nums[i];
            final int jEnd = Math.min(indexes + i, lastIndex);

            for (int j = i + 1; j <= jEnd; j++) {
                jumps[j] = Math.min(jumps[i] + 1, jumps[j]);
                if (j == lastIndex) {
                    minJumpNeeded = Math.min(minJumpNeeded, jumps[j]);
                } else if (nums[j] + jumps[i] == lastIndex) {
                    minJumpNeeded = Math.min(minJumpNeeded, jumps[j] + 1);
                }
            }
        }
        return minJumpNeeded == 2147483647 ? 0 : minJumpNeeded;
    }

}
