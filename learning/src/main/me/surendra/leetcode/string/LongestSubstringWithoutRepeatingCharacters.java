package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @see <a hred="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int lengthOfLongestSubstring(String str) {
        System.out.println(12/10);
        System.out.println(12%10);
        if (str.isEmpty()) {
            return 0;
        }
        final Set<Character> charSet = new HashSet<>();
        int left = 0;
        int longestLen = 1;
        int currentLen = 1;
        charSet.add(str.charAt(0));

        for(int right=1; right<str.length(); right++) { // n
            char currentChar = str.charAt(right);
            // Char is present in Set
            if (charSet.contains(currentChar)) { // 1
                while(str.charAt(left) != currentChar) {
                    charSet.remove(str.charAt(left));
                    left++;
                }
                left++;
                currentLen = charSet.size();
            }else{
                currentLen++;
                charSet.add(currentChar);
                longestLen = Math.max(longestLen, currentLen);
            }
        }
        return longestLen;
    }

}
