package me.surendra.leetcode.linked_list;

import java.util.Stack;


/**
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
 */
public class LinkedListNodeRemoval {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public ListNode removeNthFromEnd(ListNode head, final int n) {
        final Stack<ListNode> stack = new Stack<>();
        do {
            stack.push(head);
            head = head.next;
        } while(head != null);

        int nodeDeleteCounter = 0;
        ListNode returnLinkedList = null;
        ListNode nodeToLinked = null;

        while (!stack.empty()) {
            nodeDeleteCounter++;
            if (n == nodeDeleteCounter) {
                stack.pop();
                continue;
            }

            final ListNode currentListNode = stack.pop();
            returnLinkedList = currentListNode;
            returnLinkedList.next = nodeToLinked;
            nodeToLinked = currentListNode;
        }

        return returnLinkedList;
    }

}
