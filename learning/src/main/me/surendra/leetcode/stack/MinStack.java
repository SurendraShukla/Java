package me.surendra.leetcode.stack;

/**
 * @see <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */
interface MinStack {
    void push(int val);
    void pop();
    int top();
    int getMin();
}
