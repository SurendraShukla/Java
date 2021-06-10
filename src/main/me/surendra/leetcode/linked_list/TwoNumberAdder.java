package me.surendra.leetcode.linked_list;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 */
public class TwoNumberAdder {

    /*
        Time complexity: O(m*n) m and n represents the length of l1 and l2
        Space complexity: O(m*n)

        Dummy node simplifies the code. Without a dummy head, need to write extra conditional statements to initialize the head's value.
     */
    public ListNode addTwoNumbersUsingDummyNode(ListNode l1, ListNode l2) {
        int carry = 0;
        final ListNode dummyNode = new ListNode(0);
        ListNode currentNode = dummyNode;

        while (l1 != null || l2 != null) {
            int l1NodeVal = 0, l2NodeVal = 0;
            if (l1 != null) {
                l1NodeVal = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2NodeVal = l2.val;
                l2 = l2.next;
            }
            int val = carry + l1NodeVal + l2NodeVal;
            carry = (val > 9) ? 1 : 0;
            currentNode.next = new ListNode(val%10);
            currentNode = currentNode.next;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

    private int carry = 0;
    ListNode returnListNode = null;

    /*
        Time complexity: O(m*n) m and n represents the length of l1 and l2
        Space complexity: O(m*n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l1 != null || l2 != null) {
            int l1Val = 0, l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            populateListNode(carry + l1Val + l2Val);
        }

        if (carry > 0) {
            populateListNode(carry);
        }
        return returnListNode;
    }

    private void populateListNode(final int tmpVal) {
        int val;
        if (tmpVal < 10) {
            val = tmpVal;
            carry = 0;
        } else {
            val = tmpVal % 10;
            carry = 1;
        }
        populateNode(val);
    }

    private void populateNode(final int val) {
        final ListNode newNode = new ListNode(val);
        if (returnListNode == null) {
            returnListNode = newNode;
        }else if (returnListNode.next == null) {
            returnListNode.next = newNode;
        }else{
            ListNode tmpListNode = returnListNode;
            while(tmpListNode.next != null) {
                tmpListNode = tmpListNode.next;
            }
            tmpListNode.next = newNode;
        }
    }

}
