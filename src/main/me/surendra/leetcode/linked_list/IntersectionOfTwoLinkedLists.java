package me.surendra.leetcode.linked_list;

import java.util.Stack;

public class IntersectionOfTwoLinkedLists {

    /**
     * @param headA
     * @param headB
     * @return
     *
     * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of 2 linked list</a>
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Stack<ListNode> stack1 = LinkedList.getListNodeInStack(headA);
        final Stack<ListNode> stack2 = LinkedList.getListNodeInStack(headB);

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

}
