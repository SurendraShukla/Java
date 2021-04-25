package me.surendra.leetcode.linked_list;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of 2 linked list</a>
 */
public class ConvertBinaryNumberToInteger {

    public static int usingArithmeticOperator(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    public static int usingBitwiseOperator(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }

    public static int usingSelfThought(ListNode head) {
        final Stack<Integer> integerStack = LinkedList.getLinkedListValues(head);
        int returnVal = 0;
        int basePosition = 1;
        while (!integerStack.empty()) {
            returnVal+= basePosition * integerStack.pop();
            basePosition*=2;
        }
        return returnVal;
    }

}
