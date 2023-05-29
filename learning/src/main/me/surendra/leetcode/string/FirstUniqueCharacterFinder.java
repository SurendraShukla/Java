package me.surendra.leetcode.string;


/**
 * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique Character in a String</a>
 */
public class FirstUniqueCharacterFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int firstUniqChar(final String s) {
        final int[] charFrequencyCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charFrequencyCounts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charFrequencyCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
