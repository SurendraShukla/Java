package me.surendra.leetcode.stack.monotonic;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 */
public class DailyTemperaturesFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int[] dailyTemperatures(final int[] temperatures) {
        final int[] result = new int[temperatures.length];
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int day = stack.pop();
                result[day] = i - day;
            }
            stack.add(i);
        }
        return result;
    }

}
