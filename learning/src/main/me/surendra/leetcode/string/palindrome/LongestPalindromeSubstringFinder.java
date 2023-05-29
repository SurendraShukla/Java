package me.surendra.leetcode.string.palindrome;


/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
public class LongestPalindromeSubstringFinder {

    /*
        Time Complexity - O(n ^ 3)
        Space Complexity - O(n)
     */
    String longestPalindrome = "";
    public String longestPalindrome(final String str) {
        isPalindrome(str);
        return longestPalindrome;
    }

    private void isPalindrome(final String str) {
        if (str.isEmpty()) {
            return;
        }
        final int length = str.length();
        final int mid = length / 2;
        int leftIndex = mid;
        int rightIndex = mid;
        if (length % 2 == 0) {
            leftIndex = mid - 1;
            rightIndex = mid + 1;
        }
        while (leftIndex >= 0 && rightIndex <= length) {
            if (str.charAt(leftIndex) == str.charAt(rightIndex)) {
                final int strLen = (rightIndex - leftIndex) + 1;
                if (strLen > longestPalindrome.length()) {
                    longestPalindrome = str.substring(leftIndex, rightIndex + 1);
                }
                leftIndex--;
                rightIndex++;
            } else {
                if (leftIndex - 1 >= 0) {
                    isPalindrome(str.substring(0, leftIndex - 1));
                }
                if (rightIndex + 1 < length) {
                    isPalindrome(str.substring(rightIndex + 1, length));
                }
            }
        }
    }

}
