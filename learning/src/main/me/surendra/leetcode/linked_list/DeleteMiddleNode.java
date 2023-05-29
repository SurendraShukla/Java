package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">Delete the Middle Node of a Linked List</a>
 */
public class DeleteMiddleNode {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public ListNode deleteMiddleUsingFastAndSlowPointer(final ListNode head) {
        // Edge case: return nullptr if there is only one node.
        if (head.next == null) {
            return null;
        }
        // Initialize two pointers, 'slow' and 'fast'.
        ListNode slow = head;
        ListNode fast = head.next.next;
        // Let 'fast' move forward by 2 nodes, 'slow' move forward by 1 node each step.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // When 'fast' reaches the end, remove the next node of 'slow' and return 'head'.
        slow.next = slow.next.next;
        return head;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public ListNode deleteMiddleByCalculatingLengthFirst(final ListNode head) {
        // Edge case: return None if there is only one node
        if (head.next == null)
            return null;

        int count = 0;
        ListNode p1 = head, p2 = head;

        // First pass, count the number of nodes in the linked list using 'p1'.
        while (p1 != null) {
            count += 1;
            p1 = p1.next;
        }

        // Get the index of the node to be deleted.
        final int middleIndex = count / 2;

        // Second pass, let 'p2' move toward the predecessor of the middle node.
        for (int i = 0; i < middleIndex - 1; ++i)
            p2 = p2.next;

        // Delete the middle node and return 'head'.
        p2.next = p2.next.next;
        return head;
    }

}
