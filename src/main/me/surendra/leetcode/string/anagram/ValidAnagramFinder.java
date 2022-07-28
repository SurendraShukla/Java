package me.surendra.leetcode.string.anagram;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
 */
public class ValidAnagramFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(1) because the table's size stays constant no matter how large n is.
     */
    public boolean isAnagramUsingArrayForCharFrequency(final String s, final String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int count : chars) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /*
        Time complexity : O(n log n)
        Space complexity: O(n)
     */
    public boolean isAnagramUsingSorting(final String s, final String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final char[] str1 = s.toCharArray();
        final char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

}
