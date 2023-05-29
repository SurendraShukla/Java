package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class LinkedListNodeReverser {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    ListNode returnHeadNode;
    ListNode returnTailNode;
    public ListNode reverseListUsingRecursionUsingGlobalVariable(final ListNode head) {
        returnHeadNode = new ListNode(-1);
        returnTailNode = returnHeadNode;
        populate(head);
        return returnHeadNode.next;
    }

    private void populate(final ListNode head) {
        if (head == null) {
            return;
        }
        populate(head.next);
        head.next = null;
        returnTailNode.next = head;
        returnTailNode = returnTailNode.next;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode reverseListUsing3Pointers(ListNode currentNode) {
        ListNode previousNodeReferredAsNextNode = null;
        ListNode previousNode = currentNode;
        while (currentNode != null) {
            currentNode = previousNode.next;
            previousNode.next = previousNodeReferredAsNextNode;
            previousNodeReferredAsNextNode = previousNode;
            previousNode = currentNode;
        }
        return previousNodeReferredAsNextNode;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public static ListNode reverseListUsingRecursionAdvance(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode reversedNode = reverseListUsingRecursionAdvance(head.next);
        head.next.next = head;
        head.next = null;
        return reversedNode;
    }

}
