package me.surendra.leetcode.string.anagram;

/**
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 */
public class CommonPrefixFinder {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int minLength = Math.min(result.length(), strs[i].length());
            int j = 0;
            while (j < minLength) {
                if (result.charAt(j) != strs[i].charAt(j))
                    break;
                j++;
            }
            result = result.substring(0, j);
        }
        return result;
    }
}
