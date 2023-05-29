package me.surendra.leetcode.heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">Kth Largest Element in a Stream</a>
 */
public class KthLargestElementInAStream {

    /*
        Time complexity : O(n log k) n for iterating over nums and k keeping k elements
        Space complexity: O(k) to store the heap elements.
     */
    int max;
    PriorityQueue<Integer> pq;

    public KthLargestElementInAStream buildUsingPriorityQueue(final int k, final int[] nums) {
        this.max = k;
        pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);
        }
        while (pq.size() > k) {
            pq.remove();
        }

        return this;
    }

    public int addToPriorityQueue(final int val) {
        pq.add(val);
        if (pq.size() > max) {
            pq.remove();
        }
        return pq.peek();
    }


    int listSize = 0;
    List<Integer> list = new ArrayList<>();

    public KthLargestElementInAStream buildUsingBinarySearchList(final int k, final int[] nums) {
        this.max = k;
        listSize = nums.length;
        Arrays.sort(nums);

        for (int num: nums) {
            list.add(num);
        }
        return this;
    }

    public int addToList(final int val) {
        final int idx = getIdxToAdd(val);
        list.add(idx, val);
        listSize++;

        return list.get(listSize - (max));
    }

    int getIdxToAdd(final int targetVal) {
        int left = 0;
        int right = list.size() - 1;
        int mid = left + ((right - left) / 2);
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (list.get(mid) == targetVal) {
                return mid;
            }
            if (list.get(mid) < targetVal) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

