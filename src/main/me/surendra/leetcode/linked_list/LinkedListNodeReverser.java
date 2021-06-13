package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class LinkedListNodeReverser {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode reverseListUsing3Pointers(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode reverseListUsing2PointersAndNodeCreation(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode returnListNode;
        ListNode currentListNode = null;
        do{
            returnListNode = new ListNode(head.val, currentListNode);
            currentListNode = returnListNode;
            head = head.next;
        }while(head != null);

        return returnListNode;
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
