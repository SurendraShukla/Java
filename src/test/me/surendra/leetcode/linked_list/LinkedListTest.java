package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListTest {

    @Test
    public void shouldGetIntersectionNode() {
        final int[] intArr = {8, 4, 5};
        final int[] intArr1 = {4, 1};
        final int[] intArr2 = {5, 6, 1};

        final ListNode intersectedLinkedList = LinkedList.from(intArr);
        final ListNode linkedList1 = LinkedList.from(intArr1);
        linkedList1.next = intersectedLinkedList;
        final ListNode linkedList2 = LinkedList.from(intArr2);
        linkedList2.next = intersectedLinkedList;

        final ListNode intersectionNode = LinkedList.getIntersectionNode(linkedList1, linkedList2);
        assertThat(intersectionNode, equalTo(intersectionNode));
    }

    @Test
    public void oneNode() {
        final int[] intArr = {1};
        final int[] intArr1 = intArr;
        final int[] intArr2 = intArr;

        final ListNode listNode1 = LinkedList.from(intArr1);
        final ListNode listNode2 = LinkedList.from(intArr2);

        final ListNode intersectionNode = LinkedList.getIntersectionNode(listNode1, listNode2);
        assertThat(intersectionNode, equalTo(listNode1));
    }

}
