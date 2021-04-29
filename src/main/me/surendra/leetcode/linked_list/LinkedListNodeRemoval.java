package me.surendra.leetcode.linked_list;

import java.util.Stack;

public class LinkedListNodeRemoval {

    /**
     * @param node
     *
     * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
     */
    /*
        Time Complexity - O(1)
        Space Complexity - O(1)
    */
    public static void deleteNode(ListNode node) {
        // Todo - Why below doesn't delete node
        // node.next = node.next.next;

        // Todo - why doing this work fine.
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     *
     * @param head
     * @param n
     * @return
     *
     * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
     */
    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        final Stack<ListNode> stack = new Stack<>();
        do{
            stack.push(head);
            head = head.next;
        } while(head != null);

        int nodeDeleteCounter = 0;
        ListNode returnLinkedList = null;
        ListNode nodeToLinked = null;

        while(!stack.empty()) {
            nodeDeleteCounter++;
            if (n == nodeDeleteCounter) {
                stack.pop();
                continue;
            }

            ListNode currentListNode = stack.pop();
            returnLinkedList = currentListNode;
            returnLinkedList.next = nodeToLinked;
            nodeToLinked = currentListNode;
        }

        return returnLinkedList;
    }

}
