package me.surendra.leetcode.stack;

import java.util.Stack;


/*
    Time complexity: O(n)
    Space complexity: O(1)
 */
public class MinStackImplWith2Stacks implements MinStack {

    final Stack<Integer> noStack = new Stack<>();
    final Stack<Integer> minValStack = new Stack<>();
    public void push(final int val) {
        if (noStack.isEmpty()) {
            noStack.add(val);
            minValStack.add(val);
            return;
        }
        if (minValStack.peek() < val) {
            minValStack.add(minValStack.peek());
        } else {
            minValStack.add(val);
        }
        noStack.add(val);
    }

    public void pop() {
        noStack.pop();
        minValStack.pop();
    }

    public int top() {
        return noStack.peek();
    }

    public int getMin() {
        return minValStack.peek();
    }

}
