package me.surendra.leetcode.linked_list;


import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 */
public class MergeKSortedLists {

    /*
        Time complexity: O(n log k) N is numbers of nodes in k lists
        Space complexity: O(n) N is numbers of nodes
     */
    public ListNode mergeKListsByUsingHeap(final ListNode[] lists) {
        final PriorityQueue<ListNode> q = new PriorityQueue<>((listNode1, listNode2) -> listNode1.val - listNode2.val);
        for (ListNode listNode: lists) {
            if (listNode != null) {
                q.add(listNode);
            }
        }

        final ListNode returnNode = new ListNode(0);
        ListNode dummyNode = returnNode;
        while (!q.isEmpty()) {
            final ListNode lastNode = q.remove();
            dummyNode.next = lastNode;
            dummyNode = dummyNode.next;
            if (lastNode.next != null) {
                q.add(lastNode.next);
            }
        }

        return returnNode.next;
    }


    /*
        Time complexity: O(n log k) N is numbers of nodes in k lists
        Space complexity: O(1) Merge two sorted linked lists
     */
    public ListNode mergeKListsByDivideAndConquer(final ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeSortedLists(final ListNode list1, final ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeSortedLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeSortedLists(list2.next, list1);
            return list2;
        }
    }

    private ListNode mergeKLists(final ListNode[] lists, final int start, final int end) {
        // base cases
        if (start > end)
            return null;
        if (start == end)
            return lists[start];

        // divide and conquer
        final int middle = (end + start) / 2;
        final ListNode leftList = mergeKLists(lists, start, middle);
        final ListNode rightList = mergeKLists(lists, middle + 1, end);
        return mergeSortedLists(leftList, rightList);
    }

}
