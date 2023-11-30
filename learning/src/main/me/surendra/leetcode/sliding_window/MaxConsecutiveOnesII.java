package me.surendra.leetcode.sliding_window;


/**
 * @see <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">Max Consecutive Ones II</a>
 */
public class MaxConsecutiveOnesII {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findMaxConsecutiveOnesWith2Variables(final int[] nums) {

        int ans = 0;
        int left = -1;
        int prevLeft = -1;

        for (int right = 0;  right < nums.length; right++) {
            if (nums[right] == 0) {
                ans = Math.max(ans, right - prevLeft - 1);
                prevLeft = left;
                left = right;
            }
        }

        return Math.max(ans, nums.length - prevLeft - 1);
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findMaxConsecutiveOnes(final int[] nums) {

        int left = 0;
        int numZeroes = 0;
        int longestSequence = 0;

        // while our window is in bounds
        for (int right = 0; right < nums.length; right++) {

            // add the right most element into our window
            if (nums[right] == 0) {
                numZeroes++;
            }

            // if our window is invalid, contract our window
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // update our longest sequence answer
            longestSequence = Math.max(longestSequence, right - left + 1);
        }

        return longestSequence;
    }

}
