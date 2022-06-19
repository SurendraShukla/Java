package me.surendra.leetcode.linked_list;

public class LinkedList {

    public static ListNode from(int[] intArray) {
        ListNode listNode = null;
        for (final int aInt : intArray) {
            listNode = LinkedList.insert(listNode, aInt);
        }
        return listNode;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode insert(ListNode head, int data) {
        final ListNode p = new ListNode(data);
        if(head == null) {
            return p;
        }
        ListNode start = head;
        while(start.next != null) {
            start = start.next;
        }
        start.next = p;
        return head;
    }

    /*
        Time Complexity - O(1)
        Space Complexity - O(1)
    */
    public static ListNode createUsingDummyNode(int[] intArray) {
        final ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;
        for (final int aInt : intArray) {
            currentNode.next = new ListNode(aInt);
            currentNode = currentNode.next;
        }
        return dummyNode.next;
    }

    public static void append(ListNode listNode, ListNode nodeToBeAppended) {
        while(listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = nodeToBeAppended;
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
        System.out.println("--------------------------------------------------");
        ListNode start = head;
        while(start != null) {
            System.out.print(start.val + " -> ");
            start = start.next;
        }
        System.out.println(" ");
        System.out.println("--------------------------------------------------");
    }

}
