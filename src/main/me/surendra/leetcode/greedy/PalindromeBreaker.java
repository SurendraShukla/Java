package me.surendra.leetcode.greedy;

/**
 * @see <a href="https://leetcode.com/problems/break-a-palindrome/">Break a Palindrome</a>
 */
public class PalindromeBreaker {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String breakPalindrome(final String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        final StringBuilder stringBuilder = new StringBuilder(palindrome);
        final int strLen = stringBuilder.length();
        for (int left = 0; left < strLen / 2; left++) {
            if (stringBuilder.charAt(left) != 'a') {
                stringBuilder.setCharAt(left, 'a');
                return stringBuilder.toString();
            }
        }
        stringBuilder.setCharAt(strLen - 1, 'b');
        return stringBuilder.toString();
    }

}
