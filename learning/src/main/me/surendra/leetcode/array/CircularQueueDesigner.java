package me.surendra.leetcode.array;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/design-circular-queue/">Design Circular Queue</a>
 */
public class CircularQueueDesigner {

    /*
        Time complexity : O(1) All methods in our circular data structure is of constant time complexity.
        Space complexity: O(n) N is the pre-assigned capacity of the queue.
     */
    int left;
    int right;
    int[] queue;
    int size;
    public CircularQueueDesigner(final int k) {
        this.size = k;
        left = 0;
        right = 0;
        queue = new int[k];

        Arrays.fill(queue, -1);
    }

    public boolean enQueue(final int value) {
        if (isFull()) {
            return false;
        }
        queue[right % size] = value;
        right++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[left % size] = -1;
        left++;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[left % size];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        final int idx = (right - 1) % size;
        return queue[idx];
    }

    public boolean isEmpty() {
        return (right - left) == 0;
    }

    public boolean isFull() {
        return (right - left) >= size;
    }

}
