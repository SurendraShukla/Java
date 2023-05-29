package me.surendra.leetcode.dynamic_programming.hard;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 */
public class LongestValidParenthesesFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int longestValidParenthesesUsingStack(String s) {
        int longestValidCount = 0;
        Stack<Integer> openingBracketPositions = new Stack<>();
        openingBracketPositions.add(-1);

        for(int i=0; i<s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == '(') {
                openingBracketPositions.add(i);
            }else {
                openingBracketPositions.pop();
                if (openingBracketPositions.isEmpty()) {
                    openingBracketPositions.add(i);
                }else{
                    longestValidCount = Math.max(longestValidCount, i - openingBracketPositions.peek());
                }
            }
        }
        return longestValidCount;
    }


    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public int longestValidParenthesesBothDirection(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
