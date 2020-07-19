package me.surendra.leetcode.string;

import java.util.HashMap;
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

}
