package me.surendra.leetcode.string.anagram;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 */
public class InclusionFinder {

    public static boolean checkInclusion(String s1, String s2) {
        final int smallerStrLen = s1.length();
        final int biggerStrLen = s2.length();
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);

        for(int i = 0; i< biggerStrLen; i++) {
            int endIndex = i + smallerStrLen;
            if(endIndex > biggerStrLen) {
                continue;
            }
            String subString = s2.substring(i, endIndex);
            if (isAnagram(subString.toCharArray(), chars)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnagram(final char[] arr1, final char[] arr2) {
        Arrays.sort(arr1);
        return Arrays.equals(arr1, arr2);
    }
}
