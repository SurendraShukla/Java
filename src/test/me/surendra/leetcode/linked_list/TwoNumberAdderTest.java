package me.surendra.leetcode.linked_list;

import org.junit.Before;
import org.junit.Test;

public class TwoNumberAdderTest {

    private TwoNumberAdder twoNumberAdder;

    @Before
    public void setUp() throws Exception {
        twoNumberAdder = new TwoNumberAdder();
    }

    @Test
    public void test1() {
        final ListNode listNode1 = LinkedList.from(new int[]{2, 4, 3});
        final ListNode listNode2 = LinkedList.from(new int[]{5, 6, 4});

//        expected 7->0->8
        twoNumberAdder.addTwoNumbersUsingDummyNode(listNode1, listNode2);
    }

    @Test
    public void test2() {
        final ListNode listNode1 = LinkedList.from(new int[]{0});
        final ListNode listNode2 = LinkedList.from(new int[]{0});

//        expected 0
        twoNumberAdder.addTwoNumbersUsingDummyNode(listNode1, listNode2);
    }

    @Test
    public void test3() {
        final ListNode listNode1 = LinkedList.from(new int[]{9,9,9,9,9,9,9});
        final ListNode listNode2 = LinkedList.from(new int[]{9,9,9,9});

//        expected 8->9->9->9->0->0->0->1
        twoNumberAdder.addTwoNumbersUsingDummyNode(listNode1, listNode2);
    }

}
