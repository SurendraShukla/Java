package me.surendra.leetcode.linked_list;

import org.junit.Test;


public class LinkedListTest {

    @Test
    public void shouldReverseList_Case6() {
//        final ListNode linkedList = LinkedList.from(new int[]{1,2,3,4,5});
        final ListNode linkedList = LinkedList.from(new int[]{1,2});
        ListNode listNode = LinkedList.reverseList(linkedList);
        System.out.println(listNode);
    }




}
