package me.surendra.leetcode.array;

/**
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 */
public class FirstMissingPositiveFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int firstMissingPositive(int[] nums) {
        final int[] firstNPositiveNumbers = new int[nums.length+2];
        for (final int num : nums) {
            if (num < 0 || num > nums.length) {
                continue;
            }
            firstNPositiveNumbers[num] = num;
        }
        for (int i = 1; i < firstNPositiveNumbers.length; i++) {
            if(firstNPositiveNumbers[i] == 0) {
                return i;
            }
        }
        return 0;
    }

}
