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
