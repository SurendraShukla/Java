package me.surendra.leetcode.linked_list;

import java.util.HashSet;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of 2 linked list</a>
 */
public class IntersectionNodeOfTwoLinkedLists {

    /*
        Time Complexity - O(n+m)
        Space Complexity - O(n+m)
    */
    public static ListNode usingStack(ListNode headA, ListNode headB) {
        final Stack<ListNode> stack1 = LinkedListNodeFetcher.getLinkedListNodeInStack(headA);
        final Stack<ListNode> stack2 = LinkedListNodeFetcher.getLinkedListNodeInStack(headB);

        ListNode intersectedListNode = null;

        boolean terminateLoop = true;
        while(terminateLoop && !stack1.empty() && !stack2.empty()) {
            ListNode listNode1 = stack1.pop();
            ListNode listNode2 = stack2.pop();
            if (listNode1.equals(listNode2)) {
                intersectedListNode = listNode1;
            }else {
                terminateLoop = false;
            }
        }
        return intersectedListNode;
    }

    /*
        Time Complexity - O(n+m)
        Space Complexity - O(m)
    */
    public static ListNode usingHashSet(ListNode headA, ListNode headB) {
        final HashSet<ListNode> hastSet = LinkedListNodeFetcher.getLinkedListNodeInHashSet(headA);
        while(headB != null) {
            if (hastSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /*
        Time Complexity - O(n+m)
        Space Complexity - O(1)
    */
    public static ListNode using2Pointers(ListNode headA, ListNode headB) {
        final int linkedList1Size = LinkedList.getSize(headA);
        final int linkedList2Size = LinkedList.getSize(headB);

        if (linkedList1Size > linkedList2Size) {
            int pointerPositionToBeMoved = linkedList1Size - linkedList2Size;
            while(pointerPositionToBeMoved != 0) {
                headA = headA.next;
                pointerPositionToBeMoved--;
            }
        }else{
            int pointerPositionToBeMoved = linkedList2Size - linkedList1Size;
            while(pointerPositionToBeMoved != 0) {
                headB = headB.next;
                pointerPositionToBeMoved--;
            }
        }

        while( (headA != null) || (headB != null)) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

}
