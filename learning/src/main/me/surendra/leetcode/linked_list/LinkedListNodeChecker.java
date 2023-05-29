package me.surendra.leetcode.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle">Linked List Cycle</a>
 */
public class LinkedListNodeChecker {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public static boolean hasCycleUsing2Pointers(final ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slowRunnerNode = head;
        ListNode fastRunnerNode = head.next;

        while (slowRunnerNode != fastRunnerNode) {
            if (fastRunnerNode == null || fastRunnerNode.next == null) {
                return false;
            }
            slowRunnerNode = head.next;
            fastRunnerNode = head.next.next;
        }
        return true;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public static boolean hasCycle(ListNode head) {
        final Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

}
