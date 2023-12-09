package me.surendra.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a hred="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int lengthOfLongestSubstring(final String str) {
        final Set<Character> seenChars = new HashSet<>();
        int left = 0;
        int longestLen = 0;

        for (int right = 0; right < str.length(); right++) { // n
            final char ch = str.charAt(right);
            while (seenChars.contains(ch)) {
                seenChars.remove(str.charAt(left++));
            }
            seenChars.add(ch);
            longestLen = Math.max(longestLen, seenChars.size());
        }
        return longestLen;
    }

}
