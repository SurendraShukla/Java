package me.surendra.leetcode.sliding_window;


import java.util.HashMap;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/">Longest Substring with At Most Two Distinct Characters</a>
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int lengthOfLongestSubstringTwoDistinct(final String s) {
        int left = 0;
        int result = 0;
        final Map<Character, Integer> seenCharMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            final char rightChar = s.charAt(right);
            seenCharMap.put(rightChar, seenCharMap.getOrDefault(rightChar, 0) + 1);

            // Make window invalid
            while (seenCharMap.size() == 3) {
                final char leftChar = s.charAt(left++);
                final int leftCharFreq = seenCharMap.get(leftChar);
                if (leftCharFreq == 1) {
                    seenCharMap.remove(leftChar);
                } else {
                    seenCharMap.put(leftChar, leftCharFreq - 1);
                }
            }

            result = Math.max(result, right + 1 - left);
        }

        return result;
    }

}
