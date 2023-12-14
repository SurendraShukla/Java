package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
public class CommonPrefixFinder {

    /*
        Time Complexity - O(s) s is strs
        Space Complexity - O(1)
     */
    public static String longestCommonPrefix(final String[] strs) {
        int maxLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            maxLen = Math.min(maxLen, strs[i].length());
            for (int j = 0; j < maxLen; j++) {
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    maxLen = j;
                    break;
                }
            }
        }

        return strs[0].substring(0, maxLen);
    }
}
