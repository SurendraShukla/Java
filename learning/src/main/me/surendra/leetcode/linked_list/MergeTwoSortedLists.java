package me.surendra.leetcode.linked_list;

public class MergeTwoSortedLists {

    private static ListNode insertNode(ListNode listNode, int data) {
        ListNode tmpNode = new ListNode(data);

        if (listNode == null) {
            listNode = tmpNode;
        }else if(listNode.next == null){
            listNode.next = tmpNode;
        }else{
            ListNode start = listNode;
            while(start.next != null) {
                start = start.next;
            }
            start.next = tmpNode;
        }
        return listNode;
    }

    /*
        Time Complexity - O(n+m)
        Space Complexity - O(n+m)
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;

        while (l1 != null && l2 != null) {
            int data;
            if (l1.val < l2.val) {
                data = l1.val;
                l1 = l1.next;
            }else{
                data = l2.val;
                l2 = l2.next;
            }
            mergedList = insertNode(mergedList, data);
        }

        while(l1 != null) {
            mergedList = insertNode(mergedList, l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            mergedList = insertNode(mergedList, l2.val);
            l2 = l2.next;
        }

        return mergedList;
    }

}
