package me.surendra.leetcode.stack;

import java.util.Stack;


/*
    Time complexity: O(n)
    Space complexity: O(1)
 */
public class MinStackImplWithOneStack implements MinStack {

    private Stack<int[]> stack = new Stack<>();
    @Override
    public void push(final int x) {
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }

        final int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }

    @Override
    public void pop() {
        stack.pop();
    }

    @Override
    public int top() {
        return stack.peek()[0];
    }

    @Override
    public int getMin() {
        return stack.peek()[1];
    }

}
