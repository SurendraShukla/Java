package me.surendra.leetcode.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 */
public class LargestNumberFinder {

    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Comparator.reverseOrder());
        int no = 0;
        while (!maxHeap.isEmpty()) {
            no = maxHeap.remove();
        }
        maxHeap.remove();
        return "";
    }

}
