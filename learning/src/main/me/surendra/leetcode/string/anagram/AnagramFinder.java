package me.surendra.leetcode.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramFinder {

    public static List<Integer> findAnagrams(String s, String p) {
        final int smallerStrLen = p.length();
        final int biggerStrLen = s.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        final List<Integer> subStrIndexes = new ArrayList<>();
        for(int i = 0; i< biggerStrLen; i++) {
            int endIndex = i + smallerStrLen;
            if(endIndex > biggerStrLen) {
                continue;
            }
            String subString = s.substring(i, endIndex);
            if (isAnagram(subString.toCharArray(), chars)) {
                subStrIndexes.add(i);
            }
        }
        return subStrIndexes;
    }

    private static boolean isAnagram(final char[] arr1, final char[] arr2) {
        Arrays.sort(arr1);
        return Arrays.equals(arr1, arr2);
    }

}
