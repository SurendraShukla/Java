package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/palindromic-substrings/">Palindromic Substrings</a>
 */
public class PalindromicSubstringsFinder {

    /*
        Time Complexity - O(n ^ 2)
        Space Complexity - O(n)
     */
    public int countSubstrings(final String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += expandAround(i, i, s);
            sum += expandAround(i, i + 1, s);
        }
        return sum;
    }

    int expandAround(int left, int right, final String str) {
        int sum = 0;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                sum++;
                left--;
                right++;
            } else {
                return sum;
            }
        }
        return sum;
    }

}
