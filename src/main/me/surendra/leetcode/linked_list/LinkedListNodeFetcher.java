package me.surendra.leetcode.linked_list;

import java.util.HashSet;
import java.util.Stack;

public class LinkedListNodeFetcher {

    public static HashSet<ListNode> getLinkedListNodeInHashSet(ListNode listNode) {
        final HashSet<ListNode> listNodes = new HashSet<>();
        do {
            listNodes.add(listNode);
            listNode = listNode.next;
        } while(listNode != null);

        return listNodes;
    }

    public static Stack<ListNode> getLinkedListNodeInStack(ListNode listNode) {
        final Stack<ListNode> listNodes = new Stack<>();
        do{
            listNodes.add(listNode);
            listNode = listNode.next;
        } while(listNode != null);

        return listNodes;
    }

    public static Stack<Integer> getLinkedListNodeValues(ListNode node) {
        final Stack<Integer> integerStack = new Stack<>();
        while(node != null) {
            integerStack.push(node.val);
            node = node.next;
        }

        return integerStack;
    }

    public static Stack<Integer> getLinkedListValuesInStackInReverseOrder(ListNode node) {
        Stack<Integer> integerStack = new Stack<>();
        if(node.next != null) {
            integerStack = LinkedListNodeFetcher.getLinkedListValuesInStackInReverseOrder(node.next);
        }
        integerStack.push(node.val);
        return integerStack;
    }

}
