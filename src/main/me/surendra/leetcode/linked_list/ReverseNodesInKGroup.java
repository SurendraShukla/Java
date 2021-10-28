package me.surendra.leetcode.linked_list;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-Group</a>
 */
public class ReverseNodesInKGroup {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode tmpListNode = head;
        ListNode returnNode = new ListNode(0);
        ListNode dummyNode = returnNode;
        ListNode nonReversedNode = null;

        int counter = 0;

        while(tmpListNode != null) {
            if (counter == 0) {
                nonReversedNode = tmpListNode;
            }
            if (counter == k) {
                counter = 0;
                dummyNode.next = reverse(nonReversedNode);
                dummyNode = dummyNode.next;
            }else{
                counter++;
            }
            tmpListNode = tmpListNode.next;
        }

        if (counter < k) {
            dummyNode.next = nonReversedNode;
        }

        return returnNode.next;
    }

    public ListNode reverse(final ListNode listNode) {
        ListNode tmpListNode = listNode;
        ListNode currentNode = listNode;
        ListNode nextNode = null;
        while (tmpListNode != null) {
            tmpListNode = tmpListNode.next;
            currentNode.next = nextNode;
            nextNode = currentNode;
            currentNode = tmpListNode;
        }
        return nextNode;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public ListNode reverseKGroupUsingStack(ListNode head, int k) {
        int tmpK = k;
        ListNode firstNodeReference = null;
        final ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        final Stack<Integer> listNodeStack = new Stack<>();

        while(head != null) {
            while( (tmpK > 0) && (head != null) ) {
                if(firstNodeReference == null) {
                    firstNodeReference = head;
                }
                listNodeStack.push(head.val);
                tmpK--;
                head = head.next;
            }

            if (tmpK > 0) {
                currentNode.next = firstNodeReference;
            }else {
                while (!listNodeStack.isEmpty()) {
                    currentNode.next = new ListNode(listNodeStack.pop());
                    currentNode = currentNode.next;
                }
            }

            tmpK = k;
            firstNodeReference = null;
        }

        return dummyNode.next;
    }

}
