package me.surendra.leetcode.greedy;


import java.util.HashMap;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/">Minimum Number of Operations to Make Array Empty</a>
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minOperations(final int[] nums) {
        final Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int num: nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Integer freq: numFreqMap.values()) {
            if (freq == 1) {
                return -1;
            }
            result += Math.ceil((double) freq / 3);
        }
        return result;
    }

}
