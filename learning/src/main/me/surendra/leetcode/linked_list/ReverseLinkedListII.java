package me.surendra.leetcode.linked_list;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(final ListNode head, final int left, final int right) {
        if (left == right) {
            return head;
        }

        ListNode currentNode = head;
        final Stack<ListNode> stack = new Stack<>();
        while (currentNode != null) {
            stack.add(currentNode);
            currentNode = currentNode.next;
        }

        ListNode leftNode = null;
        ListNode middleNode = null;
        ListNode rightNode = null;
        while (!stack.isEmpty()) {
            final int stackSize = stack.size();
            final ListNode tmpNode = stack.pop();
            if (stackSize > right) {
                rightNode = tmpNode;
                continue;
            }
            if (stackSize == right) {
                tmpNode.next = null;
            }
            if (stackSize <= right && stackSize >= left) {
                middleNode = tmpNode;
            }
            if (stackSize == left - 1) {
                tmpNode.next = null;
            }
            if (stackSize <= left - 1) {
                leftNode = tmpNode;
            }
        }

        reverse(middleNode);

        if (leftNode == null) {
            middleNode.next = rightNode;
            return reverseNode.next;
        }
        leftNode.next = reverseNode.next;
        middleNode.next = rightNode;
        return leftNode;
    }

    ListNode reverseNode = new ListNode(0);
    ListNode dummyNode = reverseNode;
    private void reverse(final ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        head.next = null;
        dummyNode.next = head;
        dummyNode = dummyNode.next;
    }

}
