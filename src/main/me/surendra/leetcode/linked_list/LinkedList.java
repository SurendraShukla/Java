package me.surendra.leetcode.linked_list;

import java.util.Stack;

public class LinkedList {

    public static Stack<ListNode> getListNodeInStack(final ListNode listNode) {
        final Stack<ListNode> listNodes = new Stack<>();
        ListNode localListNode = listNode;
        listNodes.add(localListNode);
        while(localListNode.next != null) {
            localListNode = localListNode.next;
            listNodes.add(localListNode);
        }
        return listNodes;
    }

    public static Stack<Integer> getLinkedListValues(ListNode node) {
        final Stack<Integer> integerStack = new Stack<>();
        while(node.next != null) {
            integerStack.push(node.val);
            node = node.next;
        }
        integerStack.push(node.val);
        return integerStack;
    }

    public static Stack<Integer> getLinkedListValuesInReverseOrder(ListNode node) {
        Stack<Integer> integerStack = new Stack<>();
        if (node == null) {
            return integerStack;
        }
        if(node.next != null) {
            integerStack = LinkedList.getLinkedListValuesInReverseOrder(node.next);
        }
        integerStack.push(node.val);
        return integerStack;
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

    /**
     * @param node
     *
     * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void display(final ListNode head) {
        System.out.println("-----Display Started-----");
        ListNode start = head;
        while(start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
        System.out.println("");
        System.out.println("-----Display Ended-----");
    }

}
