package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 */
public class PairSwapper {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = swapPairs(head, 1);
        return listNode;
    }

    private ListNode swapPairs(ListNode head, final int nodeNumber) {
        if (head != null) {
            head.next = swapPairs(head.next, nodeNumber+1);
        }
        if (head == null) {
            return null;
        }
        if ((nodeNumber % 2 != 0) && (head.next != null) ) {
            // 3 head
            // 4 head.next

            // 4
            ListNode nextNode = head.next;
            head.next = null;
            nextNode.next = head;
            return nextNode;
        }else{
            return head;
        }
    }

}
