package me.surendra.leetcode.linked_list;

public class LinkedList {

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
     *
     * @param head
     * @return
     */
    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode returnLinkedListNode;
        ListNode nextLinkedListNode = null;
        do{
            returnLinkedListNode = new ListNode(head.val, nextLinkedListNode);
            nextLinkedListNode = returnLinkedListNode;
            head = head.next;
        }while(head != null);

        return returnLinkedListNode;
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
