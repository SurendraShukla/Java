package me.surendra.leetcode.linked_list;

import java.util.Stack;

public class LinkedList {

    /**
     * @param headA
     * @param headB
     * @return
     *
     * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of 2 linked list</a>
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Stack<ListNode> stack1 = getListNodeInStack(headA);
        final Stack<ListNode> stack2 = getListNodeInStack(headB);

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

    private static Stack<ListNode> getListNodeInStack(final ListNode listNode) {
        final Stack<ListNode> listNodes = new Stack<>();

        ListNode localListNode = listNode;
        listNodes.add(localListNode);
        while(localListNode.next != null) {
            localListNode = localListNode.next;
            listNodes.add(localListNode);
        }
        return listNodes;
    }

    public static ListNode from(int[] intArray) {
        ListNode listNode = null;
        for (final int aInt : intArray) {
//            listNode = new ListNode(aInt, listNode);
            listNode = LinkedList.insert(listNode, aInt);
        }
        return listNode;
    }

    public static ListNode insert(ListNode head, int data) {
        ListNode p = new ListNode(data);
        if(head == null) {
            head = p;
        } else if(head.next == null) {
            head.next = p;
        } else {
            ListNode start = head;
            while(start.next != null) {
                start = start.next;
            }
            start.next = p;
        }
        return head;
    }

    public static void display(final ListNode head) {
        System.out.println(" ");
        ListNode start=head;
        while(start!=null) {
            System.out.print(start.val+" ");
            start=start.next;
        }
    }

}
