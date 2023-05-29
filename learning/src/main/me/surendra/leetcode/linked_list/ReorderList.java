package me.surendra.leetcode.linked_list;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
 */
public class ReorderList {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    ListNode secondHalfReversed = new ListNode(0);
    ListNode dummyNode = secondHalfReversed;
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }

        final ListNode secondHalf = getSecondHalf(head);
        reverse(secondHalf.next);
        secondHalf.next = null;

        secondHalfReversed = secondHalfReversed.next;
        final ListNode nodeToReturn = new ListNode(0);
        ListNode dummyNode = nodeToReturn;

        while(secondHalfReversed != null) {
            ListNode leftNode = head;
            ListNode rightNode = secondHalfReversed;
            head = head.next;
            secondHalfReversed = secondHalfReversed.next;
            rightNode.next = null;
            leftNode.next = rightNode;
            dummyNode.next = leftNode;
            dummyNode = rightNode;
        }

        if (head != null) {
            head.next = null;
            dummyNode.next = head;
        }
        head = nodeToReturn.next;
        System.out.println(head);

    }

    private void reverse(final ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        head.next = null;
        dummyNode.next = head;
        dummyNode = dummyNode.next;
    }

    private ListNode getSecondHalf(final ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public void reorderListUsingLinkedList(ListNode head) {
        ListNode listNode = head;

        int size = 0;
        final LinkedList<ListNode> linkedList = new LinkedList<>();
        while (listNode != null) {
            linkedList.add(listNode);
            listNode = listNode.next;
            size++;
        }

        final ListNode returnNode = new ListNode(0);
        ListNode dummyNode = returnNode;
        while (size > 1) {
            final ListNode leftNode = linkedList.removeFirst();
            final ListNode rightNode = linkedList.removeLast();
            rightNode.next = null;
            leftNode.next = rightNode;
            dummyNode.next = leftNode;
            dummyNode = rightNode;
            size -= 2;
        }

        if (size == 1) {
            final ListNode rightNode = linkedList.remove();
            rightNode.next = null;
            dummyNode.next = rightNode;
        }

        head = returnNode.next;
    }

}
