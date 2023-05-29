package me.surendra.leetcode.linked_list;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LinkedListNodeRemovalTest {

    private final LinkedListNodeRemoval linkedListNodeRemoval = new LinkedListNodeRemoval();

    private ListNode callMethod(final int[] integers, final int n) {
        final ListNode linkedList = LinkedList.from(integers);
        return linkedListNodeRemoval.removeNthFromEnd(linkedList, n);
    }

    private void verify(final int[] integers, final ListNode actual) {
        final ListNode expected = LinkedList.from(integers);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void shouldRemoveOnlyNodeInLinkedList() {
        assertThat(callMethod(new int[]{1}, 1), Matchers.equalTo(null));
    }

    @Test
    public void shouldRemoveNthFromEnd() {
        verify(new int[]{1}, callMethod(new int[]{1, 2}, 1));
        verify(new int[]{2}, callMethod(new int[]{1, 2}, 2));
        verify(new int[]{5, 1}, callMethod(new int[]{5, 1, 9}, 1));
        verify(new int[]{5, 9}, callMethod(new int[]{5, 1, 9}, 2));
        verify(new int[]{1, 9}, callMethod(new int[]{5, 1, 9}, 3));
        verify(new int[]{1, 2, 3, 5}, callMethod(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
