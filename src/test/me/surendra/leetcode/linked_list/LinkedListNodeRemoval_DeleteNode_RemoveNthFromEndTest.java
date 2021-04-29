package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static me.surendra.leetcode.linked_list.LinkedListNodeRemoval.removeNthFromEnd;

public class LinkedListNodeRemoval_DeleteNode_RemoveNthFromEndTest {

    @Test
    public void shouldRemoveNthFromEnd_Case1() {
        final ListNode linkedList = LinkedList.from(new int[]{1});
        ListNode listNode = removeNthFromEnd(linkedList, 1);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case2() {
        final ListNode linkedList = LinkedList.from(new int[]{1,2});
        ListNode listNode = removeNthFromEnd(linkedList, 1);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case3() {
        final ListNode linkedList = LinkedList.from(new int[]{1,2});
        ListNode listNode = removeNthFromEnd(linkedList, 2);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case4() {
        final ListNode linkedList = LinkedList.from(new int[]{5, 1, 9});
        ListNode listNode = removeNthFromEnd(linkedList, 1);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case5() {
        final ListNode linkedList = LinkedList.from(new int[]{5, 1, 9});
        ListNode listNode = removeNthFromEnd(linkedList, 2);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case6() {
        final ListNode linkedList = LinkedList.from(new int[]{5, 1, 9});
        ListNode listNode = removeNthFromEnd(linkedList, 3);
        System.out.println(listNode);
    }

    @Test
    public void shouldRemoveNthFromEnd_Case7() {
        final ListNode linkedList = LinkedList.from(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = removeNthFromEnd(linkedList, 2);
        System.out.println(listNode);
    }
}
