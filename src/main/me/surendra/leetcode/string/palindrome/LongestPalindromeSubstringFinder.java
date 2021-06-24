package me.surendra.leetcode.string.palindrome;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 */
public class LongestPalindromeSubstringFinder {

    /*
        Time Complexity - O(n ^ 3)
        Space Complexity - O(n)
     */
    public String longestPalindrome(String str) {
        String longestPalindrome = "";

        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = length; j >= i+1 ; j--) {
                String subStr = str.substring(i, j);
                int subStrLen = subStr.length();
                if( (isPalindrome(subStr, subStrLen)) &&
                    (subStrLen > longestPalindrome.length())
                ) {
                    longestPalindrome = subStr;
                }
            }
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(final String subStr, final int subStrLen) {
        int startIndex = 0;
        int endIndex = subStrLen-1;
        while(startIndex < endIndex) {
            if (subStr.charAt(startIndex) != subStr.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
