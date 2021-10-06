package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/find-common-characters/">Find Common Characters</a>
 */
public class CommonCharacterFinder {

    int[] chars = new int[26];
    int[] tmpChars = new int[26];

    /*
        Time Complexity - O(?)
        Space Complexity - O(1)
     */
    public List<String> commonChars(String[] words) {
        populateChars(words[0], words[0].length());

        for (int wordIndex = 1; wordIndex < words.length; wordIndex++) {
            populateTmpChars(words[wordIndex]);
            diff();
        }

        final List<String> charList = new ArrayList<>();
        populateReturnString(charList);
        return charList;
    }

    private void populateReturnString(final List<String> charList) {
        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] != 0) {
                int charFrequency = chars[idx];
                while(charFrequency!=0) {
                    char ch = (char)(97 + idx);
                    charList.add(String.valueOf(ch));
                    charFrequency--;
                }
            }
        }
    }

    private void diff() {
        for (int idx = 0; idx < tmpChars.length; idx++) {
            if (tmpChars[idx] != chars[idx]) {
                chars[idx] = Math.min(chars[idx], tmpChars[idx]);
            }
        }
        tmpChars = new int[26];
    }

    private void populateTmpChars(final String word) {
        final int wordLength = word.length();
        for(int charIndex = 0; charIndex < wordLength; charIndex++) {
            final int idx = word.charAt(charIndex) - 'a';
            if (chars[idx] != 0) {
                tmpChars[idx]+=1;
            }
        }
    }

    private void populateChars(final String word, final int firstStrLength) {
        for (int charIndex = 0; charIndex < firstStrLength; charIndex++) {
            final int idx = word.charAt(charIndex) - 'a';
            chars[idx]+=1;
        }
    }

}
