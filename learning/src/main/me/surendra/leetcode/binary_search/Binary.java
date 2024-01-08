package me.surendra.leetcode.binary_search;

public class Binary {

    /**
     * @param nums
     * @return int
     *
     * @see <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
     */
    public static int findMaxConsecutiveOnes(final int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;
        for (final int num : nums) {
            if (num == 1) {
                currentConsecutiveOnes++;
            } else {
                if (maxConsecutiveOnes < currentConsecutiveOnes) {
                    maxConsecutiveOnes = currentConsecutiveOnes;
                }
                currentConsecutiveOnes = 0;
            }
        }
        if (maxConsecutiveOnes < currentConsecutiveOnes) {
            maxConsecutiveOnes = currentConsecutiveOnes;
        }
        return maxConsecutiveOnes;
    }

}
