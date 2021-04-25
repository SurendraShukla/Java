package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListTest {

    @Test
    public void shouldDeleteNod() {
        final ListNode expectedList = LinkedList.from(new int[]{5, 1, 9});

        final ListNode linkedList = LinkedList.from(new int[]{4});
        linkedList.next = expectedList;

        // execute
        LinkedList.deleteNode(linkedList);
//        assertThat(expectedList, equalTo(linkedList));
    }

}
