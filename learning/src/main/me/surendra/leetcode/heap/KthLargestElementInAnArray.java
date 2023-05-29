package me.surendra.leetcode.heap;

import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 */
public class KthLargestElementInAnArray {

    /*
        Time complexity : O(n log k) n for iterating over nums and k keeping k elements
        Space complexity: O(k) to store the heap elements.
     */
    public int findKthLargestUsingHeap(final int[] nums, final int k) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.remove();
    }

}
