package me.surendra.hacker_rank.linked_list;

public class LinkedList {

    public static Node from(final int[] intArray)  {
        Node head = null;
        for (final int anInt : intArray) {
            head = LinkedList.insert(head, anInt);
        }
        return head;
    }

    public static Node removeDuplicates(final Node passedNode) {
        Node returnNode = null;
        if(passedNode.next != null) {
            returnNode = LinkedList.removeDuplicates(passedNode.next);
        }
        if (passedNode.next == null) {
            return passedNode;
        }
        if(passedNode.data == returnNode.data) {
            passedNode.next = returnNode.next;
        }
        return passedNode;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if(head == null) {
            head = p;
        } else if(head.next == null) {
            head.next = p;
        } else {
            Node start = head;
            while(start.next != null) {
                start = start.next;
            }
            start.next = p;
        }
        return head;
    }

    public static void display(final Node head) {
        System.out.println(" ");
        Node start=head;
        while(start!=null) {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }

}
