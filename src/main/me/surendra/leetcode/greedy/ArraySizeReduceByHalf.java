package me.surendra.leetcode.greedy;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/reduce-array-size-to-the-half/">Reduce Array Size to The Half</a>
 */
public class ArraySizeReduceByHalf {

    /*
        Time Complexity - O(n log n) Priority Queue
        Space Complexity - O(n)
     */
    public int minSetSize(final int[] arr) {
        final Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        for (int no: arr) {
            final int noFrequency = numberFrequencyMap.getOrDefault(no, 0);
            numberFrequencyMap.put(no, noFrequency + 1);
        }

        final PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (Integer numberFrequency: numberFrequencyMap.values()) {
            q.add(numberFrequency);
        }

        int numbersRemoved = 0;
        int numbers = 0;
        while (numbersRemoved < arr.length / 2 && !q.isEmpty()) {
            numbersRemoved += q.remove();
            numbers++;
        }
        return numbers;
    }

}
