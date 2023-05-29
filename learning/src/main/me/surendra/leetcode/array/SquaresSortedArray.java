package me.surendra.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 */
public class SquaresSortedArray {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int[] sortedSquares(int[] nums) {
        final TreeSet<Integer> sortedArr = new TreeSet<>();
        final Map<Integer, Integer> integerMap = new HashMap<>();
        for (final int num : nums) {
            int square = num * num;
            sortedArr.add(square);
            if (integerMap.containsKey(square)) {
                integerMap.put(square, integerMap.get(square)+1);
            }else{
                integerMap.put(square, 1);
            }
        }
        final int[] returnArr = new int[nums.length];
        int counter = 0;
        for (final Integer integer : sortedArr) {
            Integer total = integerMap.get(integer);
            while(total != 0) {
                returnArr[counter++] = integer;
                total--;
            }
        }
        return returnArr;
    }

}
