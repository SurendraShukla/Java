package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TwoNumberAdderTest {

    private TwoNumberAdder twoNumberAdder = new TwoNumberAdder();
    public ListNode callMethod(final ListNode listNode1, final ListNode listNode2) {
        return twoNumberAdder.addTwoNumbersUsingDummyNode(listNode1, listNode2);
    }

    @Test
    public void test1() {
        final ListNode listNode1 = LinkedList.from(new int[]{2, 4, 3});
        final ListNode listNode2 = LinkedList.from(new int[]{5, 6, 4});

        final ListNode actual = callMethod(listNode1, listNode2);

        final ListNode expected = LinkedList.from(new int[]{7, 0, 8});
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final ListNode listNode1 = LinkedList.from(new int[]{0});
        final ListNode listNode2 = LinkedList.from(new int[]{0});

        final ListNode actual = callMethod(listNode1, listNode2);

        final ListNode expected = LinkedList.from(new int[]{0});
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final ListNode listNode1 = LinkedList.from(new int[]{9, 9, 9, 9, 9, 9, 9});
        final ListNode listNode2 = LinkedList.from(new int[]{9, 9, 9, 9});

        final ListNode actual = callMethod(listNode1, listNode2);

        final ListNode expected = LinkedList.from(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        assertThat(actual, equalTo(expected));
    }

}
