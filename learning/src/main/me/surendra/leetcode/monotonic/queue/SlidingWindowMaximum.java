package me.surendra.leetcode.monotonic.queue;


import me.surendra.learning.generics.Pair;

import java.util.Deque;
import java.util.LinkedList;



/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 */
public class SlidingWindowMaximum {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int[] maxSlidingWindowUsingMonotonicQueue(final int[] nums, final int k) {

        int idx = 0;
        final int[] result = new int[nums.length + 1 - k];
        final Deque<Pair<Integer, Integer>> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekLast().getKey() < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(new Pair(nums[i], i));
            if (dq.peekFirst().getValue() <=  i - k) {
                dq.removeFirst();
            }
            if (i < k - 1) {
                continue;
            }
            result[idx++] = dq.peekFirst().getKey();
        }

        return result;
    }

}
