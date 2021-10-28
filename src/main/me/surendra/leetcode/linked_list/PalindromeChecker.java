package me.surendra.leetcode.linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list">Palindrome Linked List</a>
 */
public class PalindromeChecker {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public static boolean isPalindromeUsingFastAndSlowPointer(ListNode head) {
        if (head.next == null) {
            return true;
        }

        final Stack<ListNode> nodeStack = new Stack<>();
        ListNode slower = head;
        ListNode faster = head;

        while( faster != null
            && faster.next != null
        ) {
            nodeStack.add(slower);
            slower = slower.next;
            faster = faster.next.next;
        }

        while(slower != null && !nodeStack.isEmpty()) {
            slower = slower.next;
            int val1 = nodeStack.pop().val;
            if (val1 != slower.val) {
                return false;
            }
        }

        if (slower.next != null || !nodeStack.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public static boolean isPalindrome(ListNode head) {
        int endPointer = -1;
        final List<Integer> integerList = new ArrayList<>();
        do {
            integerList.add(head.val);
            endPointer++;
            head = head.next;
        } while(head != null);

        int startPointer = 0;
        while(startPointer < endPointer) {
            if (integerList.get(startPointer).intValue() != integerList.get(endPointer).intValue() ) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }

}
