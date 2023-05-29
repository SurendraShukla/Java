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

    /**
     * 1. Iterate over linkedList
     *    If k nodes found;
     *        Break the linked list
     *        Reverse it
     *        Attach it to returnHeadNode
     * 2. If remaining nodes (non reversed) are smaller than k nodes;
     *    Attach it to returnHeadNode
     */
    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public ListNode reverseKGroupUsingExtraSpace(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode returnHeadNode = new ListNode(-1);
        ListNode returnTailNode = returnHeadNode;
        int tmpK = 0;
        ListNode startNode = head;

        while(head != null) {
            tmpK++;
            if (k == tmpK) {
                ListNode nextNode = head.next;
                head.next = null;
                returnTailNode.next= reverseListUsing3Pointers(startNode);
                returnTailNode = startNode;
                head = nextNode;
                startNode = head;
                tmpK = 0;
            } else {
                head = head.next;
            }
        }

        if (tmpK < k) {
            returnTailNode.next= startNode;
        }
        return returnHeadNode.next;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public ListNode reverseListUsing3Pointers(ListNode currentNode) {
        ListNode previousNodeReferredAsNextNode = null;
        ListNode previousNode = currentNode;
        while(currentNode != null) {
            currentNode = previousNode.next;
            previousNode.next = previousNodeReferredAsNextNode;
            previousNodeReferredAsNextNode = previousNode;
            previousNode = currentNode;
        }
        return previousNodeReferredAsNextNode;
    }

}
