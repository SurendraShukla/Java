package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    public static int minStepsToMake2StringAnagram(String s, String t) {
        int[] charsCount = new int[26];
        for (char c : s.toCharArray()) {
            charsCount[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if (charsCount[c-'a'] > 0) {
                charsCount[c-'a']--;
            }
        }
        int minStep = 0;
        for (int i=0; i<charsCount.length; i++) {
            if (charsCount[i] > 0) {
                minStep+= charsCount[i];
            }
        }
        return minStep;
    }

    public static int minStepsToMake2StringAnagramUsingMap(String s, String t) {
        final Map<Character, Integer> chars = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            final char ch = s.charAt(i);
            chars.compute(ch, (key, val) -> (val == null) ? 1 : val + 1);
        }

        System.out.println(chars);

        for(int j=0; j<t.length(); j++) {
            final char ch = t.charAt(j);
            chars.computeIfPresent(ch, (key, val) -> (val == 0) ? 0 : val - 1);
        }

        int minStep = 0;
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() > 0) {
                minStep+= entry.getValue();
            }
        }

        return minStep;
    }

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
