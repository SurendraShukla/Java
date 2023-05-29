package me.surendra.leetcode.linked_list;

import java.util.List;

public class LinkedList {

    public static ListNode from(final Integer ...integers) {
        ListNode listNode = null;
        for (final int aInt : integers) {
            listNode = LinkedList.insert(listNode, aInt);
        }
        return listNode;
    }

    public static ListNode from(final List<Integer> integers) {
        ListNode listNode = null;
        for (final int aInt : integers) {
            listNode = LinkedList.insert(listNode, aInt);
        }
        return listNode;
    }

    public static ListNode from(final int[] integers) {
        ListNode listNode = null;
        for (final int aInt : integers) {
            listNode = LinkedList.insert(listNode, aInt);
        }
        return listNode;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode insert(final ListNode head, final int data) {
        final ListNode p = new ListNode(data);
        if (head == null) {
            return p;
        }
        ListNode start = head;
        while (start.next != null) {
            start = start.next;
        }
        start.next = p;
        return head;
    }

    /*
        Time Complexity - O(1)
        Space Complexity - O(1)
    */
    public static ListNode createUsingDummyNode(final List<Integer> integers) {
        final ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        for (final int aInt : integers) {
            currentNode.next = new ListNode(aInt);
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }

    /*
        Time Complexity - O(1)
        Space Complexity - O(1)
    */
    public static ListNode createUsingDummyNode(final int[] integers) {
        final ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        for (final int aInt : integers) {
            currentNode.next = new ListNode(aInt);
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }

    public static void append( ListNode listNode, final ListNode nodeToBeAppended) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = nodeToBeAppended;
    }


    public static int getSize(final ListNode node) {
        ListNode currentNode = node;
        int size = 1;
        while (currentNode.next != null) {
            size++;
            currentNode = node.next;
        }
        return size;
    }

    public static void display(final ListNode head) {
        System.out.println("--------------------------------------------------");
        ListNode start = head;
        while (start != null) {
            System.out.print(start.val + " -> ");
            start = start.next;
        }
        System.out.println(" ");
        System.out.println("--------------------------------------------------");
    }

}
