package me.surendra.leetcode.linked_list;

import java.util.ArrayList;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list">Palindrome Linked List</a>
 */
public class PalindromeChecker {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1) - Changing the pointers one-by-one, in-place. Not creating/storing the nodes in list or somewhere
    */
    ListNode previousListNode = null;
    ListNode reversedListNode = null;
    public boolean isPalindrome(ListNode head) {
        // 1. Base Condition for One Node
        if (head.next == null)  return true;
        // 2. Get Mid of Linked list
        ListNode midNode = getMidNode(head);
        // 3. Reverse 2nd half of Linked list
        reverse(midNode.next);
        // 4. Split Linked List from Mid
        midNode.next = null;
        // 5. Compare values of 1st Half (Head) with 2nd Half (Reversed)
        return isPalindrome(head, reversedListNode);
    }

    private boolean isPalindrome(ListNode head, ListNode reversedListNode) {
        while(head != null && reversedListNode != null) {
            if (head.val != reversedListNode.val) {
                return false;
            }
            head = head.next;
            reversedListNode = reversedListNode.next;
        }
        return true;
    }

    private ListNode getMidNode(final ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    private void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        if (reversedListNode == null) {
            reversedListNode = head;
            previousListNode = head;
        }else{
            head.next = null;
            previousListNode.next = head;
            previousListNode = previousListNode.next;
        }
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public boolean isPalindromeUsingList(ListNode head) {
        final List<Integer> listNodeList = new ArrayList<>();

        int leftPointer = 0;
        int rightPointer = -1;
        while (head != null) {
            listNodeList.add(head.val);
            head = head.next;
            rightPointer++;
        }

        while (leftPointer < rightPointer) {
            if (!listNodeList.get(leftPointer).equals(listNodeList.get(rightPointer))) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    private ListNode frontPointer;
    public boolean isPalindromeRecursivelyAdvanced(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /*
        Iterate nodes in reverse using recursion and
        Iterate forward at the same time using a variable outside the recursive function and
        Then we can check whether its palindrome or not.

        Below is an example of Printing algo
            function print_values_in_reverse(ListNode head)
                if head is NOT null
                    print_values_in_reverse(head.next)
                    print head.val
     */
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }



}
