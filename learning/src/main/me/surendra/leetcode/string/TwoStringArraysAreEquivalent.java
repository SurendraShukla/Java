package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Check If Two String Arrays are Equivalent</a>
 */
public class TwoStringArraysAreEquivalent {

    /*
     Time Complexity - O(n)
     Space Complexity - O(1)
     */
    public boolean arrayStringsAreEqual(final String[] word1, final String[] word2) {
        final StringBuilder sb1 = new StringBuilder();
        for (String word: word1) {
            sb1.append(word);
        }

        final StringBuilder sb2 = new StringBuilder();
        for (String word: word2) {
            sb2.append(word);
        }

        return sb1.toString().equals(sb2.toString());
    }

}
