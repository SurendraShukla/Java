package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MergeKSortedListsTest {

    private final MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

    ListNode callMethod(final Integer[][] lists) {
        final ListNode[] linkedLists = convert(lists);

        return mergeKSortedLists.mergeKListsByUsingHeap(linkedLists);
    }

    private ListNode[] convert(final Integer[][] lists) {
        final ListNode[] linkedLists = new ListNode[lists.length];
        int idx = 0;
        for (Integer[] list: lists) {
            linkedLists[idx] = LinkedList.from(list);
            idx++;
        }
        return linkedLists;
    }

    @Test
    public void merge3Lists() {
        final Integer[][] integers = {{1, 4, 5}, {1, 3, 4}, {2, 6}};

        final ListNode actual = callMethod(integers);

        final ListNode expected = LinkedList.from(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void mergeEmptyList() {
        final int[] expectedIntegers = {};
        final ListNode expected = LinkedList.from(expectedIntegers);

        assertThat(callMethod(new Integer[][]{}), equalTo(expected));
        assertThat(callMethod(new Integer[][]{{}}), equalTo(expected));
    }
}
