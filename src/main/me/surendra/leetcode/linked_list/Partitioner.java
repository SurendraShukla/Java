package me.surendra.leetcode.linked_list;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/partition-list/">Partition List</a>
 */
public class Partitioner {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public ListNode partitionUsing2Pointer(ListNode head, int x) {
        final ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        final ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;      // Why this is not changing pointer of beforeHead list?
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public ListNode partitionUsingStackOfInteger(ListNode head, int x) {
        final Stack<Integer> smallerNumbers = new Stack<>();
        final Stack<Integer> nonSmallerNumbers = new Stack<>();

        while (head != null) {
            final int currentVal = head.val;
            if (currentVal < x) {
                smallerNumbers.push(currentVal);
            }else{
                nonSmallerNumbers.push(currentVal);
            }
            head = head.next;
        }

        ListNode listNode = null;
        while(!nonSmallerNumbers.isEmpty()) {
            listNode = new ListNode(nonSmallerNumbers.pop(), listNode);
        }
        while(!smallerNumbers.isEmpty()) {
            listNode = new ListNode(smallerNumbers.pop(), listNode);
        }
        return listNode;
    }

}
