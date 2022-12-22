package me.surendra.leetcode.dynamic_programming.one_d;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 *
 */
public class HouseRobberII {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    Map<String, Integer> memo;
    int[] houses;
    public int rob(final int[] nums) {
        memo = new HashMap<>();
        if (nums.length == 1) {
            return nums[0];
        }
        this.houses = nums;
        return Math.max(
            rob(0, nums.length - 2),
            rob(1, nums.length - 1)
        );
    }

    private int rob(final int startIdx, final int lastIdx) {
        if (startIdx > lastIdx) {
            return 0;
        }
        final String key = startIdx + "_" + lastIdx;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        final int profit = Math.max(
            rob(startIdx + 1, lastIdx),
            houses[startIdx] + rob(startIdx + 2, lastIdx)
        );

        memo.put(key, profit);
        return profit;
    }

}
