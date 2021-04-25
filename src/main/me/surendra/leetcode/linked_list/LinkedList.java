package me.surendra.leetcode.linked_list;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

    public static HashSet<ListNode> getListNodeInHashSet(ListNode listNode) {
        final HashSet<ListNode> listNodes = new HashSet<>();
        listNodes.add(listNode);
        while(listNode.next != null) {
            listNode = listNode.next;
            listNodes.add(listNode);
        }
        return listNodes;
    }

    public static Stack<ListNode> getListNodeInStack(ListNode listNode) {
        final Stack<ListNode> listNodes = new Stack<>();
        listNodes.add(listNode);
        while(listNode.next != null) {
            listNode = listNode.next;
            listNodes.add(listNode);
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

    public static void append(ListNode listNode, ListNode nodeToBeAppended) {
        while(listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = nodeToBeAppended;
    }

    /**
     * @param node
     *
     * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
     */
    public static void deleteNode(ListNode node) {
        // Todo - Why below doesn't delete node
        // node.next = node.next.next;

        // Todo - why doing this work fine.
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static int getSize(ListNode node) {
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
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
