package me.surendra.leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Evaluate Reverse Polish Notation</a>
 */
public class EvaluateReversePolishNotation {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int evalRPN(String[] tokens) {
        final Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        final Stack<Integer> integerStack = new Stack<>();

        for (final String token : tokens) {
            if (operators.contains(token)) {
                final Integer no2 = integerStack.pop();
                final Integer no1 = integerStack.pop();
                integerStack.push(eval(no1, no2, token));
            } else {
                integerStack.push(Integer.valueOf(token));
            }
        }

        final Integer result = integerStack.pop();
        return result;
    }

    private Integer eval(final Integer no1, final Integer no2, final String token) {
        switch (token) {
            case "+":
                return no1 + no2;
            case "-":
                return no1 - no2;
            case "*":
                return no1 * no2;
            case "/":
                return no1 / no2;
        }
        return 0;
    }

}
