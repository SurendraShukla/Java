package me.surendra.leetcode.monotonic.queue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(final int[] nums, final int k) {
        if (k == 1) {
            return nums;
        }

        final int[] left = new int[nums.length];
        final int[] right = new int[nums.length];
        for (int j = 0; j < nums.length; j += k) {
            int i = 0;
            int leftValMax = nums[i];
            final int leftIdxMax = Math.min(i + k, nums.length);
            while (i < leftIdxMax) {
                leftValMax = Math.max(leftValMax, nums[i]);
                left[i] = leftValMax;
                i++;
            }
            i--;
            int rightValMax = nums[i];
            final int rightIdxMax = Math.max(i - k, 0);
            while (i >= rightIdxMax) {
                rightValMax = Math.max(rightValMax, nums[i]);
                right[i] = rightValMax;
                i--;
            }
        }

        final int[] maxSlidingWindow = new int[nums.length - k + 1];
        for (int i = k - 1, j = 0; i <= nums.length; i++) {
            maxSlidingWindow[j] = Math.max(left[i], right[i]);
            j++;
        }

        return maxSlidingWindow;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int[] maxSlidingWindowUsingMonotonicQueue(final int[] nums, final int k) {
        if (k == 1) {
            return nums;
        }

        int i = 0;
        final Deque<Integer> monotonicQueue = new LinkedList<>();
        final int[] maxSlidingWindow = new int[nums.length - k + 1];
        while (i < nums.length) {
            if (i >= k) {
                final int idx = i - k;
                maxSlidingWindow[idx] = monotonicQueue.peekFirst();
                if (monotonicQueue.peekFirst() == nums[idx]) {
                    monotonicQueue.pollFirst();
                }
            }
            if (monotonicQueue.size() >= 1) {
                while (!monotonicQueue.isEmpty() &&
                    monotonicQueue.peekLast() < nums[i]
                ) {
                    monotonicQueue.pollLast();
                }
            }
            monotonicQueue.add(nums[i]);
            i++;
        }

        maxSlidingWindow[i - k] = monotonicQueue.peekFirst();
        return maxSlidingWindow;
    }

}
