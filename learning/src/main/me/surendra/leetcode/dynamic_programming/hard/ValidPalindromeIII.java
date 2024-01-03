package me.surendra.leetcode.dynamic_programming.hard;


/**
 * @see <a href="https://leetcode.com/problems/valid-palindrome-iii/">Valid Palindrome III</a>
 */
public class ValidPalindromeIII {

    /*
        Time Complexity - O(n * n)
        Space Complexity - O(n * n)
     */
    String str;
    int strLen;
    Integer[][] cache;
    public boolean isValidPalindrome(final String s, final int k) {
        str = s;
        strLen = s.length();
        cache = new Integer[strLen][strLen];

        return isValidPalindrome(0, strLen - 1) <= k;
    }

    private int isValidPalindrome(final int left, final int right) {
        if (left == right) {
            return 0;
        }
        if (left == right - 1) {
            return str.charAt(left) == str.charAt(right) ? 0 : 1;
        }

        if (cache[left][right] != null) {
            return cache[left][right];
        }

        int result = 0;
        if (str.charAt(left) == str.charAt(right)) {
            result = isValidPalindrome(left + 1, right - 1);
        } else {
            result = 1 + Math.min(
                isValidPalindrome(left + 1, right),
                isValidPalindrome(left, right - 1)
            );
        }

        cache[left][right] = result;
        return result;
    }

}
