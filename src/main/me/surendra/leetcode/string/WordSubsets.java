package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/word-subsets/">Word Subsets</a>
 */
public class WordSubsets {

    /**
        Time Complexity - O(m + n) m for word1 and n for word2
        Space Complexity - O(m + n) m for word1 and n for word2

        Get frequencies for letters in words1 array and compare with
        GetMaxFrequencies of words2, check if it is valid
        If yes then add it to a result list
     */
    public List<String> wordSubsets(final String[] words1, final String[] words2) {
        final int[] maximumCharFrequency = getMaxFrequencies(words2);

        final List<String> universalStrings = new ArrayList<>();
        for (String word1: words1) {
            final int[] characterFrequency = getCharacterFrequency(word1);
            if (subset(characterFrequency, maximumCharFrequency)) {
                universalStrings.add(word1);
            }
        }
        return universalStrings;
    }

    private boolean subset(final int[] characterFrequency, final int[] maximumCharFrequency) {
        for (int i = 0; i < 26; i++) {
            if (characterFrequency[i] < maximumCharFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    // Get maximum of frequency of letters for all words in an array
    private int[] getMaxFrequencies(final String[] setForWords2) {
        final int[] maximumCharFrequency = new int[26];
        for (String word2: setForWords2) {
            for (int i = 0; i < 26; i++) {
                final int[] currentWordCharFrequency = getCharacterFrequency(word2);
                maximumCharFrequency[i] = Math.max(maximumCharFrequency[i], currentWordCharFrequency[i]);
            }
        }
        return maximumCharFrequency;
    }

    // Get frequency of letters for a word
    private int[] getCharacterFrequency(final String word) {
        final int[] charFrequencyForWord = new int[26];
        for (char aChar: word.toCharArray()) {
            charFrequencyForWord[aChar - 'a']++;
        }
        return charFrequencyForWord;
    }

}
