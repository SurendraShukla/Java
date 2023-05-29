package me.surendra.leetcode.linked_list;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ReverseLinkedListIITest {

    private ListNode callMethod(final ListNode listNode, final int left, final int right) {
        return new ReverseLinkedListII().reverseBetween(listNode, left, right);
    }

    @Test
    public void test1() {
        final ListNode actual = callMethod(LinkedList.from(5), 1, 1);

        final ListNode expected = LinkedList.from(5);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final ListNode actual = callMethod(LinkedList.from(1, 2, 3, 4, 5), 3, 4);

        final ListNode expected = LinkedList.from(1, 2, 4, 3, 5);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final ListNode actual = callMethod(LinkedList.from(1, 2, 3, 4, 5, 6, 7, 8, 9), 1, 8);

        final ListNode expected = LinkedList.from(1, 8, 7, 6, 5, 4, 3, 2, 9);

        assertThat(actual, equalTo(expected));
    }

}
