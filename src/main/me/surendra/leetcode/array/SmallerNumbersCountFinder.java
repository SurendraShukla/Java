package me.surendra.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/">How Many Numbers Are Smaller Than the Current Number</a>
 */
public class SmallerNumbersCountFinder {

    /*
        Time Complexity - O(n log n) Sorting an array
        Space Complexity - O(n) n for storing array elements
     */
    public int[] smallerNumbersThanCurrent(final int[] nums) {
        final int[] sortedArr = nums.clone();
        Arrays.sort(sortedArr);

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            if (!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], i);
            }
        }

        for (int j = 0; j < nums.length; j++) {
            nums[j] = map.get(nums[j]);
        }

        return nums;
    }

}
