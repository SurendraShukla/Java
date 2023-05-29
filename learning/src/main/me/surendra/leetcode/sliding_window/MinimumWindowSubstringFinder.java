package me.surendra.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 */
public class MinimumWindowSubstringFinder {

    int left = 0;
    int right = 0;
    String str;
    int need = 0;
    int have = 0;
    String maxString = "";
    Map<Character, Integer> tFrquency = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    public String minWindow(final String s, final String t) {
        if (s.length() < t.length()) {
            return "";
        }

        str = s;
        populateTChars(t);

        for (char sChar: s.toCharArray()) {
            if (tFrquency.containsKey(sChar)) {
                window.put(sChar, window.get(sChar) + 1);
                if (window.get(sChar) == tFrquency.get(sChar)) {
                    have++;
                }
                // System.out.println("sChar=["+sChar+"] have=["+have+"] tFrquency=["+tFrquency.get(sChar)+"] window=["+window.get(sChar)+"]");
                if (have == need) {
                    System.out.println("\n inside if sChar=["+sChar+"]");
                    populateMinimumWindowSubstring();
                }
            }
            right++;
        }

        return maxString;
    }

    private void populateMinimumWindowSubstring() {
        if (left > right) return;
        final String subString = str.substring(left, right);
        System.out.println("left=[" + left + "] right=[" + right + "] subString=[" + subString + "]");
        if (maxString.isEmpty() || maxString.length() > subString.length()) {
            maxString = subString;
        }

        final char aChar = str.charAt(left);
        System.out.println("\nleft=[" + left + "] right=[" + right + "] aChar=[" + aChar + "]");
        if (tFrquency.containsKey(aChar) && window.get(aChar) < tFrquency.get(aChar)) {
            have--;
        }
        left++;
        System.out.println("left=[" + left + "] right=[" + right + "] aChar=[" + aChar + "] window=[" + window.get(aChar) + "] tFrquency=[" + tFrquency.get(aChar) + "]");
        populateMinimumWindowSubstring();
    }


    private void populateTChars(final String str) {
        for (char aChar: str.toCharArray()) {
            tFrquency.put(aChar, tFrquency.getOrDefault(aChar, 0) + 1);
            window.put(aChar, 0);
        }
        need = tFrquency.size();
    }

}
