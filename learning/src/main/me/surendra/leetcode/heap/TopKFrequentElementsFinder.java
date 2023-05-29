package me.surendra.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 */
public class TopKFrequentElementsFinder {

    /*
        Time Complexity - O(n log n)
        Space Complexity- O(n)
     */
    public int[] topKFrequentUsingHeapReferringMap(final int[] nums, final int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> map.get(a1) - map.get(a2));
        for (Map.Entry<Integer, Integer> noInfo: map.entrySet()) {
            pq.add(noInfo.getKey());
            if (pq.size() > k) {
                pq.remove();
            }
        }

        final int[] returnList = new int[k];
        int idx = k - 1;
        while (!pq.isEmpty()) {
            returnList[idx] = pq.remove();
            idx--;
        }

        return returnList;
    }

    /*
        Time Complexity - O(n log n)
        Space Complexity- O(n)
     */
    public int[] topKFrequentUsingHeap(final int[] nums, final int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        for (Map.Entry<Integer, Integer> noInfo: map.entrySet()) {
            pq.add(new int[]{noInfo.getKey(), noInfo.getValue()});
            if (pq.size() > k) {
                pq.remove();
            }
        }

        final int[] returnList = new int[k];
        int idx = k - 1;
        while (!pq.isEmpty()) {
            returnList[idx] = pq.remove()[0];
            idx--;
        }

        return returnList;
    }

    /*
        Time Complexity - O(n log n)
        Space Complexity- O(n)
     */
    public int[] topKFrequentUsingSorting(final int[] nums, final int k) {
        final Map<Integer, Integer> noWithItsFrequency = new HashMap<>();
        for (final int no : nums) {
            noWithItsFrequency.put(no, noWithItsFrequency.getOrDefault(no, 0) + 1);
        }

        return noWithItsFrequency
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(k)
            .mapToInt(map -> map.getKey())
            .toArray();
    }

}
