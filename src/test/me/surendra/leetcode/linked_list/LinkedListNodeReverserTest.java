package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LinkedListNodeReverserTest {


    private ListNode callMethod(final ListNode input) {
//        return new LinkedListNodeReverser().reverseListUsingRecursion(input);
//        return new LinkedListNodeReverser().reverseListUsingRecursionWithDummyNode(input);
//        return new LinkedListNodeReverser().reverseListUsing2PointersAndNodeCreation(input);
//        return new LinkedListNodeReverser().reverseListUsing3Pointers(input);
        return new LinkedListNodeReverser().reverseListUsingIterationWithDummyNode(input);
    }

    @Test
    public void test1() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{});

        // execute
        final ListNode output = callMethod(input);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test2() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{1,2});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{2,1});

        // execute
        final ListNode output = callMethod(input);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test3() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{1,2,3});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{3,2,1});

        // execute
        final ListNode output = callMethod(input);

        assertThat(output, equalTo(expected));
    }

    @Test
    public void test5() {
        final ListNode input = LinkedList.createUsingDummyNode(new int[]{1,2,3,4,5});
        final ListNode expected = LinkedList.createUsingDummyNode(new int[]{5,4,3,2,1});

        // execute
        final ListNode output = callMethod(input);

        assertThat(output, equalTo(expected));
    }

}
