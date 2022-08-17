package me.surendra.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/unique-morse-code-words/">Unique Morse Code Words</a>
 */
public class UniqueMorseCodeWordsFinder {
    final static String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(final String[] words) {
        final Set<String> uniqueTransformation = new HashSet<>();
        for (String word: words) {
            final StringBuilder strBuilder = new StringBuilder();
            for (char ch: word.toCharArray()) {
                strBuilder.append(MORSE[ch - 'a']);
            }
            uniqueTransformation.add(strBuilder.toString());
        }
        return uniqueTransformation.size();
    }

}
