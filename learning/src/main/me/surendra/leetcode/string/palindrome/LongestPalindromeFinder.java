package me.surendra.leetcode.string.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindrome/">Longest Palindrome</a>
 */
public class LongestPalindromeFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int longestPalindrome(final String str) {
        final char[] charCounts = new char[128];
        for (char c: str.toCharArray()) {
            charCounts[c]++;
        }

        int answer = 0;
        for (final char charCount : charCounts) {
            answer+= (charCount / 2) * 2;
            if ((answer % 2 == 0) && (charCount % 2 == 1)) {
                answer++;
            }
        }
        return answer;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int longestPalindromeUsingCharArray(final String str) {
        final char[] charCounts = new char[128];

        for (char c: str.toCharArray()) {
            charCounts[c]++;
        }

        int longestPalindromeLength = 0;
        boolean oddCountNotUsed = true;
        for (final char charCount : charCounts) {
            if (charCount == 0) {
                continue;
            }
            if (charCount % 2 == 0) {
                longestPalindromeLength+=charCount;
                continue;
            }
            if (oddCountNotUsed) {
                longestPalindromeLength+=charCount;
                oddCountNotUsed = false;
                continue;
            }
            longestPalindromeLength+=(charCount/2)*2;
        }
        return longestPalindromeLength;
    }

}
