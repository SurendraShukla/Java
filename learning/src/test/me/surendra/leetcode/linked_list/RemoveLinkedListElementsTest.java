package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class RemoveLinkedListElementsTest {

    private ListNode callMethod(final ListNode input, final int val) {
//        return new RemoveLinkedListElements().removeElements(input, val);
        return new RemoveLinkedListElements().removeElementsUsingSentinelNode(input, val);
    }

    @Test
    public void test1() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{1,2,6,3,4,5,6});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{1,2,3,4,5});

        // execute
        final ListNode output = callMethod(input, 6);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test2() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{1,2,6,3,4,5,6});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{2,6,3,4,5,6});

        // execute
        final ListNode output = callMethod(input, 1);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test3() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{});

        // execute
        final ListNode output = callMethod(input, 1);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test4() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{7,7,7,7});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{});

        // execute
        final ListNode output = callMethod(input, 7);

        assertThat(output, equalTo(expected));
    }
}
