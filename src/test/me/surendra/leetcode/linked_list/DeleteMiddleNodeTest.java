package me.surendra.leetcode.linked_list;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DeleteMiddleNodeTest {

    private final DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();

    private ListNode callMethod(final Integer ...integers) {
        final ListNode listNode = LinkedList.from(integers);

        return deleteMiddleNode.deleteMiddleUsingFastAndSlowPointer(listNode);
//        return deleteMiddleNode.deleteMiddleByCalculatingLengthFirst(listNode);
    }

    private void verify(final ListNode actual, final int[] integers) {
        final ListNode expected = LinkedList.from(integers);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test() {
        verify(
            callMethod(1, 3, 4, 7, 1, 2, 6),
            new int[]{1, 3, 4, 1, 2, 6}
        );

        verify(
            callMethod(1, 2, 3, 4),
            new int[]{1, 2, 4}
        );

        verify(
            callMethod(2, 1),
            new int[]{2}
        );

        assertThat(callMethod(1), equalTo(null));
    }

}
