package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">String to Integer (atoi)</a>
 */
public class StringToIntegerAtoi {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int myAtoi(final String s) {
        boolean isPositive = true;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            final char aChar = s.charAt(i);
            if (aChar == ' ') {
                continue;
            }
            if (aChar == '+') {
                isPositive = true;
                continue;
            }
            if (aChar == '-') {
                isPositive = false;
                continue;
            }
            int digit = (aChar - '0');
            if (digit >= 0 && digit <= 9) {
                if( (Integer.MAX_VALUE / 10 <= result) ||
                    (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)
                ) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = (result * 10) + digit;
            } else {
                break;
            }
        }

        return result * (isPositive ? 1 : -1);
    }


}
