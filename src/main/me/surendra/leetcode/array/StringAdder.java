package me.surendra.leetcode.array;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/add-strings/">Add Strings</a>
 */
public class StringAdder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String addStrings(final String num1, final String num2) {
        int num1Len = num1.length()-1;
        int num2Len = num2.length()-1;

        final StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while(num1Len >=0 || num2Len >= 0) {
            final Integer integer1 = num1Len < 0 ? 0 : num1.charAt(num1Len--) - '0';
            final Integer integer2 = num2Len < 0 ? 0 : num2.charAt(num2Len--) - '0';
            final Integer sum = carry + integer1 + integer2;
            carry = (sum > 9) ? 1 : 0;
            stringBuilder.append(sum%10);
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }


    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String addStringsUsingStack(final String num1, final String num2) {
        final Stack<Integer> integerStack1 = new Stack<>();
        final Stack<Integer> integerStack2 = new Stack<>();

        for (final char aChar : num1.toCharArray()) {
            integerStack1.push(Character.getNumericValue(aChar));
        }
        for (final char aChar : num2.toCharArray()) {
            integerStack2.push(Character.getNumericValue(aChar));
        }

        final Stack<Integer> integerStack3 = new Stack<>();
        int carry = 0;
        while(!integerStack1.isEmpty() || !integerStack2.isEmpty()) {
            final Integer integer1 = integerStack1.isEmpty() ? 0 : integerStack1.pop();
            final Integer integer2 = integerStack2.isEmpty() ? 0 : integerStack2.pop();
            final Integer sum = carry + integer1 + integer2;
            carry = (sum > 9) ? 1 : 0;
            integerStack3.add(sum%10);
        }
        if (carry > 0) {
            integerStack3.add(carry);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        while(!integerStack3.isEmpty()) {
            stringBuilder.append(integerStack3.pop());
        }
        return stringBuilder.toString();
    }

}
