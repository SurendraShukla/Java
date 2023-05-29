package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/string-to-integer-atoi/">String to Integer (atoi)</a>
 */
public class StringToIntegerAtoi {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int myAtoi(final String str) {
        int index = 0;
        int result= 0;
        int sign = 1;

        if (str.length() == 0) {
            return 0;
        }

        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while(index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit >= 0 && digit <= 9) {
                if( (Integer.MAX_VALUE / 10 < result) ||
                    (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)
                ) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = (result * 10) + digit;
            } else {
                break;
            }
            index++;
        }
        return result * sign;
    }


}
