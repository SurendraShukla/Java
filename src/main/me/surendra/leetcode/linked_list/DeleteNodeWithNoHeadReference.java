package me.surendra.leetcode.linked_list;


/**
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">Delete Node in a Linked List</a>
 */
public class DeleteNodeWithNoHeadReference {

    /*
        Time Complexity - O(1)
        Space Complexity - O(1)
    */
    public void deleteNode(final ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
    */
    public void deleteNodeIteratingLinkedList(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
