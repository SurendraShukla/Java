package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
 */
public class DuplicateRemovalFromSortedList {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
