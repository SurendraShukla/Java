package me.surendra.leetcode.linked_list;

import org.junit.Test;

public class LinkedListNodeRemoval_DeleteNode {

    @Test
    public void shouldDeleteNod() {
        final ListNode expectedList = LinkedList.from(new int[]{5, 1, 9});

        final ListNode linkedList = LinkedList.from(new int[]{4});
        linkedList.next = expectedList;

        // execute
        LinkedListNodeRemoval.deleteNode(linkedList);
//        assertThat(expectedList, equalTo(linkedList));
    }


}
