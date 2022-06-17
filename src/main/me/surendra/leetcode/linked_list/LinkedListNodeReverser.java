package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class LinkedListNodeReverser {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    ListNode returnListNode;
    ListNode dummyListNode;
    public ListNode reverseListUsingRecursionUsingGlobalVariable(ListNode head) {
        populate(head);
        return returnListNode;
    }

    private void populate(final ListNode head) {
        if(head == null) {
            return;
        }
        populate(head.next);
        if (returnListNode == null) {
            returnListNode = head;
            dummyListNode = returnListNode;
        }else{
            head.next = null;
            dummyListNode.next = head;
            dummyListNode = dummyListNode.next;
        }
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode reverseListUsing3Pointers(ListNode head) {
        ListNode previousNodeReferredAsNextNode = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNodeReferredAsNextNode;
            previousNodeReferredAsNextNode = currentNode;
            currentNode = nextNode;
        }
        return previousNodeReferredAsNextNode;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public static ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = reverseListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return dummyNode;
    }


}
