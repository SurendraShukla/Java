package me.surendra.leetcode.linked_list;

import org.junit.Test;

import static me.surendra.leetcode.linked_list.IntersectionNodeOfTwoLinkedLists.using2Pointers;
import static me.surendra.leetcode.linked_list.IntersectionNodeOfTwoLinkedLists.usingHashSet;
import static me.surendra.leetcode.linked_list.IntersectionNodeOfTwoLinkedLists.usingStack;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class IntersectionNodeOfTwoLinkedListsTest {

    @Test
    public void shouldGetIntersectionNode() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{8, 4, 5});
        final ListNode linkedList1 = LinkedList.from(new int[]{4, 1});
        LinkedList.append(linkedList1, linkedListCommon);
        final ListNode linkedList2 = LinkedList.from(new int[]{5, 6, 1});
        LinkedList.append(linkedList2, linkedListCommon);

        assertThat(usingStack(linkedList1, linkedList2), equalTo(linkedListCommon));
        assertThat(usingHashSet(linkedList1, linkedList2), equalTo(linkedListCommon));
        assertThat(using2Pointers(linkedList1, linkedList2), equalTo(linkedListCommon));
    }

    @Test
    public void shouldGetIntersectionNodeForOneNode() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1});
        final ListNode linkedList1 = linkedListCommon;
        final ListNode linkedList2 = linkedListCommon;

        assertThat(usingStack(linkedList1, linkedList2), equalTo(linkedListCommon));
        assertThat(usingHashSet(linkedList1, linkedList2), equalTo(linkedListCommon));
        assertThat(using2Pointers(linkedList1, linkedList2), equalTo(linkedListCommon));
    }

}
