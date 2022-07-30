package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/word-subsets/">Word Subsets</a>
 */
public class WordSubsets {

    /*
        Time Complexity - O(m + n) m for word1 and n for word2
        Space Complexity - O(m + n) m for word1 and n for word2
     */
    public List<String> wordSubsets(final String[] words1, final String[] words2) {

        final Set<String> setForWords2 = new HashSet<>();
        Collections.addAll(setForWords2, words2);

        final int[] maximumCharFrequency = new int[26];
        for (String word2: setForWords2) {
            for (int i = 0; i < 26; i++) {
                final int[] currentWordCharFrequency = getCharacterFrequency(word2);
                maximumCharFrequency[i] = Math.max(maximumCharFrequency[i], currentWordCharFrequency[i]);
            }
        }

        final List<String> universalStrings = new ArrayList<>();
        for (String word1: words1) {
            if (isSubset(maximumCharFrequency, getCharacterFrequency(word1))) {
                universalStrings.add(word1);
            }
        }
        return universalStrings;
    }

    private boolean isSubset(final int[] subsetWordCharFrequency, final int[] wordCharacterFrequency) {
        for (int i = 0; i < 26; i++) {
            if (wordCharacterFrequency[i] < subsetWordCharFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharacterFrequency(final String word) {
        final int[] charFrequencyForWord = new int[26];
        for (char aChar: word.toCharArray()) {
            charFrequencyForWord[aChar - 'a']++;
        }
        return charFrequencyForWord;
    }

}
