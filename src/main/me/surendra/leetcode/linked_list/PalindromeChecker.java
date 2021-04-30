package me.surendra.leetcode.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list">Palindrome Linked List</a>
 */
public class PalindromeChecker {

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
