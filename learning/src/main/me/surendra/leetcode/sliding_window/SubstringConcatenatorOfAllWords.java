package me.surendra.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words/">Substring with Concatenation of All Words</a>
 */
public class SubstringConcatenatorOfAllWords {

    public List<Integer> findSubstring(final String s, final String[] words) {
        final List<Integer> indices = new ArrayList<>();
        final int totalWords = words.length;
        final int wordLen = words[0].length();
        final int subStrLen = totalWords * wordLen;
        if (s.length() < subStrLen) {
            return indices;
        }

        Arrays.sort(words);
        // Iterate only for
        for (int i = 0; i < wordLen; i++) {
            final String[] slidingWindow = new String[totalWords];
            for (int subStrStartIndex = i, slidingWindowIndex = 1;
                 subStrStartIndex < s.length();
                 subStrStartIndex += wordLen, slidingWindowIndex++
            ) {
                final int slidingModIndex = slidingWindowIndex % totalWords;
                final int subStringEndIndex = Math.min(subStrStartIndex + wordLen, s.length());
                slidingWindow[slidingModIndex] = s.substring(subStrStartIndex, subStringEndIndex);
                if (slidingWindowIndex >= totalWords) {
                    if (slidingWindowContainsAllSubStrings(slidingWindow, words)) {
                        indices.add(subStrStartIndex - subStrLen + wordLen);
                    }
                }
            }
        }
        return indices;
    }

    private boolean slidingWindowContainsAllSubStrings(final String[] slidingWindow, final String[] words) {
        final String[] tmpSlidingWindow = slidingWindow.clone();
        Arrays.sort(tmpSlidingWindow);
        return Arrays.equals(tmpSlidingWindow, words);
    }

}
