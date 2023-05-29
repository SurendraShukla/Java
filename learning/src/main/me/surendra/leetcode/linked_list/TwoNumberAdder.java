package me.surendra.leetcode.linked_list;


/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
public class TwoNumberAdder {

    /*
        Time complexity: O(max(m, n)) m and n represents the length of l1 and l2
        Space complexity: O(max(m, n))

        Dummy node simplifies the code. Without a dummy head, need to write extra conditional statements to initialize the head's value.
     */
    public ListNode addTwoNumbersUsingDummyNode(ListNode l1, ListNode l2) {
        final ListNode returnNode = new ListNode(0);
        ListNode dummyNode = returnNode;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1NodeVal = 0;
            int l2NodeVal = 0;
            if (l1 != null) {
                l1NodeVal = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2NodeVal = l2.val;
                l2 = l2.next;
            }
            final int sum = carry + l1NodeVal + l2NodeVal;
            carry = sum / 10;
            dummyNode.next = new ListNode(sum % 10);
            dummyNode = dummyNode.next;
        }

        if (carry > 0) {
            dummyNode.next = new ListNode(carry);
        }
        return returnNode.next;
    }

}
