package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
 */
public class RemoveLinkedListElements {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode returnNode = null;
        ListNode previousNode = null;
        boolean nodeFound = false;
        while(head != null) {
            if (head.val == val) {
                head = head.next;
                nodeFound = true;
                continue;
            }
            if (returnNode == null) {
                returnNode = head;
            }
            if (nodeFound && previousNode != null) {
                previousNode.next = head;
            }
            nodeFound = false;
            previousNode = head;
            head = head.next;
        }
        if (nodeFound && previousNode != null) {
            previousNode.next = head;
        }
        return returnNode;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public ListNode removeElementsUsingSentinelNode(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

}
