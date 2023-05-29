package me.surendra.leetcode.array;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/last-stone-weight/">Last Stone Weight</a>
 */
public class LastStoneWeigher {

    /*
        Time complexity : O(N log N)
        Space complexity: O(n)
     */
    public int lastStoneWeight(int[] stones) {
        // Heap/Priority data structure
        // Java has Min Heap Queue
        final PriorityQueue<Integer> stoneSet = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++) {
            stoneSet.add(stones[i]);
        }
        while(stoneSet.size() > 1) { // n
            int maxElement = stoneSet.poll(); // log n
            int secondMaxElement = stoneSet.poll(); // log n
            if (maxElement != secondMaxElement) {
                stoneSet.add(maxElement-secondMaxElement); // log n
            }
        }
        return stoneSet.isEmpty() ? 0 : stoneSet.poll();
    }

}
