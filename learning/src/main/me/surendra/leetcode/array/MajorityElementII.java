package me.surendra.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/majority-element-ii/">Majority Element II</a>
 */
public class MajorityElementII {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<Integer> majorityElement(final int[] nums) {
        final int majorityElement = (nums.length / 3) + 1;
        final List<Integer> result = new ArrayList<>();
        final Map<Integer, Integer> noFreqMap = new HashMap<>();
        for (int no: nums) {
            final int freq = noFreqMap.getOrDefault(no, 0) + 1;
            noFreqMap.put(no, freq);
            if (freq == majorityElement) {
                result.add(no);
            }
        }
        return result;
    }

}
