package me.surendra.leetcode.linked_list;


import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ReorderListTest {

    private void callMethod(final ListNode listNode) {
        new ReorderList().reorderList(listNode);
//        new ReorderList().reorderListUsingLinkedList(listNode);
    }

    @Test
    public void oneNode() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1));

        callMethod(listNode);

        assertThat(listNode, equalTo(listNode));
    }

    @Test
    public void twoNode() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1, 2));

        callMethod(listNode);

        assertThat(listNode, equalTo(listNode));
    }

    @Test
    public void threeNodes() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1, 2, 3));

        callMethod(listNode);

        final ListNode expectedListNode = LinkedList.from(Lists.newArrayList(1, 3, 2));
        assertThat(listNode, equalTo(expectedListNode));
    }

    @Test
    public void fourNodes() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1, 2, 3, 4));

        callMethod(listNode);

        final ListNode expectedListNode = LinkedList.from(Lists.newArrayList(1, 4, 2, 3));
        assertThat(listNode, equalTo(expectedListNode));
    }

    @Test
    public void fiveNodes() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1, 2, 3, 4, 5));

        callMethod(listNode);

        final ListNode expectedListNode = LinkedList.from(Lists.newArrayList(1, 5, 2, 4, 3));
        assertThat(listNode, equalTo(expectedListNode));
    }

    @Test
    public void sixNodes() {
        final ListNode listNode = LinkedList.from(Lists.newArrayList(1, 2, 3, 4, 5, 6));

        callMethod(listNode);

        final ListNode expectedListNode = LinkedList.from(Lists.newArrayList(1, 6, 2, 5, 3, 4));
        assertThat(listNode, equalTo(expectedListNode));
    }


}
