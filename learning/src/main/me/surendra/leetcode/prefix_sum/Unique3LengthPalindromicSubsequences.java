package me.surendra.leetcode.prefix_sum;


import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/">Unique Length-3 Palindromic Subsequences</a>
 */
public class Unique3LengthPalindromicSubsequences {

    /*
        Time Complexity - O(n); O(26n) => O(n)
        Space Complexity- O(1) first, last, and between all use constant space (26 characters array)
     */
    public int countPalindromicSubsequence(final String s) {
        final Integer[] first = new Integer[26];
        final Integer[] last = new Integer[26];

        for (int i = 0; i < s.length(); i++) {
            final int curr = s.charAt(i) - 'a';
            if (first[curr] == null) {
                first[curr] = i;
            }
            last[curr] = i;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) { // 26
            if (first[i] == null) {
                continue;
            }
            final Set<Character> between = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) { // n
                between.add(s.charAt(j));
            }

            result += between.size();
        }

        return result;
    }

}
