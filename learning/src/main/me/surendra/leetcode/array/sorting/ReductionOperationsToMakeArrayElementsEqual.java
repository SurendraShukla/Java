package me.surendra.leetcode.array.sorting;


import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/">Reduction Operations to Make the Array Elements Equal</a>
 */
public class ReductionOperationsToMakeArrayElementsEqual {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int reductionOperations(final int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int steps = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                steps++;
            }

            ans += steps;
        }

        return ans;
    }

}
