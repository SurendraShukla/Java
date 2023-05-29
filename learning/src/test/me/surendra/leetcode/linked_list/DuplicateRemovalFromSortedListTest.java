package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DuplicateRemovalFromSortedListTest {

    private ListNode callMethod(final ListNode input) {
        return new DuplicateRemovalFromSortedList().deleteDuplicates(input);
    }

    @Test
    public void test1() {
        final ListNode input = LinkedList.from(new int[]{1,1,2});
        final ListNode output= LinkedList.from(new int[]{1,2});

        assertThat(callMethod(input), equalTo(output));
    }

    @Test
    public void test2() {
        final ListNode input = LinkedList.from(new int[]{1,1,2,3,3});
        final ListNode output= LinkedList.from(new int[]{1,2,3});

        assertThat(callMethod(input), equalTo(output));
    }

}
