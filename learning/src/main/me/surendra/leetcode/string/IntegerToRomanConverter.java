package me.surendra.leetcode.string;


/**
 * @see <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 */
public class IntegerToRomanConverter {

    /*
        Time complexity : O(1)
            This upper limit is 15 times, and it occurs for the number 3888, which has a representation of MMMDCCCLXXXVIII.
        Space complexity: O(1)
     */
    private static final int[] values = {1000,  900,  500,  400,  100,  90,  50,  40,  10,  9,  5,  4,  1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(final int num) {
        int number = num;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                sb.append(symbols[i]);
                number -= values[i];
            }
        }

        return sb.toString();
    }

    /*
         Time complexity : O(1)
           The same number of operations is done, regardless of the size of the input.
           Therefore, the time complexity is constant.
         Space complexity: O(1)
     */
    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String intToRomanUsingHardcodeDigits(final int num) {
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

}
