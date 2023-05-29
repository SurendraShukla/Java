package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class DeleteNodeWithNoHeadReferenceTest {

    private void callMethod(final ListNode head) {
        new DeleteNodeWithNoHeadReference().deleteNode(head);
//        new DeleteNodeWithNoHeadReference().deleteNodeIteratingLinkedList(head);
    }

    @Test
    public void shouldDeleteNode1() {
        final ListNode head = LinkedList.from(4);
        final ListNode inputNode = LinkedList.from(5, 1, 9);
        head.next = inputNode;

        // execute
        callMethod(inputNode);

        final ListNode expected = LinkedList.from(4, 1, 9);
        assertThat(head, equalTo(expected));
    }

    @Test
    public void shouldDeleteNode2() {
        final ListNode head = LinkedList.from(4, 5);
        final ListNode inputNode = LinkedList.from(1, 9);
        head.next.next = inputNode;

        // execute
        callMethod(inputNode);

        final ListNode expected = LinkedList.from(4, 5, 9);
        assertThat(head, equalTo(expected));
    }

    @Test
    public void shouldDeleteNode3() {
        final ListNode head = LinkedList.from(4, 5);

        // execute
        callMethod(head);

        final ListNode expected = LinkedList.from(5);
        assertThat(head, equalTo(expected));
    }

}
