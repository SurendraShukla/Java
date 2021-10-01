package me.surendra.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
 */
public class HouseRobber {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int robUsingDpTopDownApproachWithVariables(int[] nums) {
        int i = nums.length-1;
        int no1 = 0;
        int no2 = nums[i];

        while(i > 0) {
            int tmp = Math.max(nums[i-1] + no1, no2);
            no1 = no2;
            no2 = tmp;
            i--;
        }
        return no2;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int robUsingDpTopDownApproachWithTable(int[] nums) {
        final int length = nums.length;
        int[] memoization = new int[length +1];
        memoization[length] = 0;
        memoization[length-1] = nums[length-1];

        for (int i = length-2; i >= 0; i--) {
            memoization[i] = Math.max(nums[i] + memoization[i+2], memoization[i+1]);
        }
        return memoization[0];
    }

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int robUsingDpBottomUpApproachWithVariables(int[] nums) {
        int no1 = 0;
        int no2 = nums[0];
        int i = 1;

        while(i < nums.length) {
            int tmp = Math.max(nums[i] + no1, no2);
            no1 = no2;
            no2 = tmp;
            i++;
        }
        return no2;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int robUsingDpBottomUpApproachWithTable(int[] nums) {
        final int length = nums.length;
        int[] memoization = new int[length +1];
        memoization[0] = 0;
        memoization[1] = nums[0];

        for (int i = 1; i < length; i++) {
            memoization[i+1] = Math.max(nums[i] + memoization[i-1], memoization[i]);
        }
        return memoization[length];
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    private int[] memo;
    public int robUsingRecursionWithMemoization(int[] nums) {
        this.memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {
        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);

        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }

}
