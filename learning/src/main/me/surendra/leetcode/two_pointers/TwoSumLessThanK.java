package me.surendra.leetcode.two_pointers;


import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-less-than-k/">Two Sum Less Than K</a>
 */
public class TwoSumLessThanK {

    /*
     Time Complexity - O(n log n)
     Space Complexity - O(1)
     */
    public int twoSumLessThanK2Pointers(final int[] nums, final int k) {

        Arrays.sort(nums);

        int sum = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            final int curSum = nums[left] + nums[right];
            if (curSum < k) {
                sum = Math.max(sum, curSum);
                left++;
            } else {
                right--;
            }
        }

        return sum;
    }

    /*
     Time Complexity - O(n ^ 2)
     Space Complexity - O(1)
     */
    public int twoSumLessThanKBruteForce(final int[] nums, final int k) {
        int sum = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                final int curSum = nums[i] + nums[j];
                if (curSum < k) {
                    sum = Math.max(sum, curSum);
                }
            }
        }
        return sum;
    }

}
