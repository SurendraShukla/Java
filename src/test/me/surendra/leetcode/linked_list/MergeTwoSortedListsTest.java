package me.surendra.leetcode.linked_list;

import org.junit.Test;

public class MergeTwoSortedListsTest {

    @Test
    public void bothLinkedListAreNull() {
        final ListNode linkedList1 = LinkedList.from(new int[]{});
        final ListNode linkedList2 = LinkedList.from(new int[]{});

        System.out.println(MergeTwoSortedLists.mergeTwoLists(linkedList1, linkedList2));
    }


    @Test
    public void oneLinkedListIsNullOtherIsNot() {
        final ListNode linkedList1 = LinkedList.from(new int[]{});
        final ListNode linkedList2 = LinkedList.from(new int[]{0});

        System.out.println(MergeTwoSortedLists.mergeTwoLists(linkedList1, linkedList2));
    }

    @Test
    public void bothLinkedListAreNotNull() {
        final ListNode linkedList1 = LinkedList.from(new int[]{1, 2, 4});
        final ListNode linkedList2 = LinkedList.from(new int[]{1, 3, 4});

        System.out.println(MergeTwoSortedLists.mergeTwoLists(linkedList1, linkedList2));
    }

}
