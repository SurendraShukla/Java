package me.surendra.leetcode.linked_list;


/**
 * @see <a href="https://leetcode.com/problems/design-circular-queue/">Design Circular Queue</a>
 */
public class CircularQueueDesigner {

    /*
        Time complexity : O(1) All methods in our circular data structure is of constant time complexity.
        Space complexity: O(n) N is the pre-assigned capacity of the queue.
     */
    ListNode head;
    ListNode tail;
    int total = 0;
    int size;
    public CircularQueueDesigner(final int k) {
        size = k;
    }

    public boolean enQueue(final int value) {
        if (isFull()) {
            return false;
        }
        final ListNode listNode = new ListNode(value);
        if (total == 0) {
            head = listNode;
        } else {
            tail.next = listNode;
        }
        total++;
        tail = listNode;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        total--;
        head = head.next;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total >= size;
    }

}
