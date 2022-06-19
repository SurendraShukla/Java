package me.surendra.leetcode.heap;

import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 */
public class KthLargestElementFinder {

    /*
        Time complexity : O(n log k) n is the elements in array and k is heap size
        Space complexity: O(k)
     */
    public int findKthLargestUsingHeap(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.remove();
    }

}
