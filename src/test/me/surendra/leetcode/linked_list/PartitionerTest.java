package me.surendra.leetcode.linked_list;

import org.junit.Test;

public class PartitionerTest {

    private ListNode callMethod(final ListNode listNode, final int x) {
        return new Partitioner().partitionUsing2Pointer(listNode, x);
    }

    @Test
    public void testWithMultipleSmallerAndNonSmallerNodes() {
        final int[] array = {1,4,3,2,5,2};
        callMethod(LinkedList.from(array), 3);
    }

    @Test
    public void testWithSingleSmallerAndNonSmallerNodes() {
        final int[] array = {2,1};
        callMethod(LinkedList.from(array), 2);
    }

    @Test
    public void testWithSmallerAndNoNonSmallerNodes() {
        final int[] array = {2,1};
        callMethod(LinkedList.from(array), 3);
    }

    @Test
    public void testWithNoSmallerAndSmallerNodes() {
        final int[] array = {2,1};
        callMethod(LinkedList.from(array), 0);
    }


}
