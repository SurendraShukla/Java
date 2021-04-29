package me.surendra.leetcode.linked_list;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/">Convert Binary Number in a Linked List to Integer</a>
 */
public class ConvertBinaryNumberToInteger {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static int usingArithmeticOperator(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static int usingBitwiseOperator(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static int usingSelfThought(ListNode head) {
        final Stack<Integer> integerStack = LinkedListNodeFetcher.getLinkedListNodeValues(head);
        int returnVal = 0;
        int basePosition = 1;
        while (!integerStack.empty()) {
            returnVal+= basePosition * integerStack.pop();
            basePosition*=2;
        }
        return returnVal;
    }

}
