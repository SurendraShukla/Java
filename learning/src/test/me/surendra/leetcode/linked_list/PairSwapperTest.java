package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PairSwapperTest {

    private ListNode callMethod(final ListNode head) {
        return new PairSwapper().swapPairs(head);
    }

    @Test
    public void test1() {
        assertThat(callMethod(null), equalTo(null));
    }

    @Test
    public void test2() {
        final ListNode inputList = LinkedList.from(new int[]{1});

        assertThat(callMethod(inputList), equalTo(inputList));
    }

    @Test
    public void test3() {
        final ListNode inputList = LinkedList.from(new int[]{1,2});
        final ListNode expectedList = LinkedList.from(new int[]{2,1});

        assertThat(callMethod(inputList), equalTo(expectedList));
    }

    @Test
    public void test4() {
        final ListNode inputList = LinkedList.from(new int[]{1,2,3});
        final ListNode expectedList = LinkedList.from(new int[]{2,1,3});

        assertThat(callMethod(inputList), equalTo(expectedList));
    }

    @Test
    public void test5() {
        final ListNode inputList = LinkedList.from(new int[]{1,2,3,4});
        final ListNode expectedList = LinkedList.from(new int[]{2,1,4,3});

        assertThat(callMethod(inputList), equalTo(expectedList));
    }

    @Test
    public void test6() {
        final ListNode inputList = LinkedList.from(new int[]{1,2,3,4,5,6,7,8,9,10});
        final ListNode expectedList = LinkedList.from(new int[]{2,1,4,3,6,5,8,7,10,9});
//        [1,2,3,4,5,null,null,6,null,7,8,9,null,10,null,null,null,11]

        assertThat(callMethod(inputList), equalTo(expectedList));
    }
}
