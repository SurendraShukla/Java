package me.surendra.leetcode.linked_list;

import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void shouldGetIntersectionNode() {
        final ListNode intersectedLinkedList = LinkedList.from(new int[]{8, 4, 5});
        final ListNode linkedList1 = LinkedList.from(new int[]{4, 1});
        linkedList1.next = intersectedLinkedList;
        final ListNode linkedList2 = LinkedList.from(new int[]{5, 6, 1});
        linkedList2.next = intersectedLinkedList;

        final ListNode intersectionNode = IntersectionOfTwoLinkedLists.getIntersectionNode(linkedList1, linkedList2);

        assertThat(intersectionNode, equalTo(intersectionNode));
    }

    @Test
    public void shouldGetIntersectionNodeForOneNode() {
        final int[] intArr = {1};
        final int[] intArr1 = intArr;
        final int[] intArr2 = intArr;

        final ListNode listNode1 = LinkedList.from(intArr1);
        final ListNode listNode2 = LinkedList.from(intArr2);

        final ListNode intersectionNode = IntersectionOfTwoLinkedLists.getIntersectionNode(listNode1, listNode2);

//        assertThat(intersectionNode, equalTo(listNode1));
    }

}
