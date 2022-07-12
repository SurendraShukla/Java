package me.surendra.leetcode.set;


import java.util.HashSet;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 */
public class LongestConsecutiveSequence {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public int longestConsecutive(final int[] nums) {
        final Set<Integer> seenNumbers = new HashSet<>();
        for (int num: nums) {
            seenNumbers.add(num);
        }

        int max = 0;
        for (int num: nums) {
            if (seenNumbers.contains(num - 1)) {
                continue;
            }
            int currentMax = 1;
            int currentNum = num;
            while (seenNumbers.contains(currentNum + 1)) {
                currentMax++;
                currentNum++;
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }

}
