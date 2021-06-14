package me.surendra.leetcode.linked_list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup reverseNodesInKGroup;

    @Before
    public void setUp() {
        reverseNodesInKGroup = new ReverseNodesInKGroup();
    }

    private ListNode callMethod(final ListNode input, final int k) {
        return reverseNodesInKGroup.reverseKGroupUsingStack(input, k);
    }

    @Test
    public void test1() {
        final ListNode input = LinkedList.from(new int[]{1});
        final ListNode output= LinkedList.from(new int[]{1});

        assertThat(callMethod(input, 1), equalTo(output));
    }

    @Test
    public void test2() {
        final ListNode input = LinkedList.from(new int[]{1, 2});
        final ListNode output= LinkedList.from(new int[]{2, 1});

        assertThat(callMethod(input, 2), equalTo(output));
    }

    @Test
    public void test3() {
        final ListNode input = LinkedList.from(new int[]{1, 2, 3, 4, 5});
        final ListNode output= LinkedList.from(new int[]{3, 2, 1, 4, 5});

        assertThat(callMethod(input, 3), equalTo(output));
    }

    @Test
    public void test4() {
        final ListNode input = LinkedList.from(new int[]{1, 2, 3, 4, 5});
        final ListNode output= LinkedList.from(new int[]{1, 2, 3, 4, 5});

        assertThat(callMethod(input, 1), equalTo(output));
    }

    @Test
    public void test5() {
        final ListNode input = LinkedList.from(new int[]{1, 2, 3, 4, 5});
        final ListNode output= LinkedList.from(new int[]{1, 2, 3, 4, 5});

        assertThat(callMethod(input, 6), equalTo(output));
    }

}
