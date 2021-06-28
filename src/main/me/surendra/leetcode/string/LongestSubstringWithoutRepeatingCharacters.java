package me.surendra.leetcode.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a hred="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Time Complexity - O(n ^ 3)
        Space Complexity - O(k)
     */
    public int lengthOfLongestSubstring(String str) {
        Queue<Character> characterQueue = new LinkedList<>();
        int maxLen = 0;
        int currentLen = 0;

        for (int i = 0; i < str.length(); i++) { // n
            char aChar = str.charAt(i);
            if (characterQueue.contains(aChar)) { // n
                while(aChar != characterQueue.peek()) { // n
                    characterQueue.remove();
                    currentLen--;
                }
                characterQueue.remove();
            }else{
                currentLen++;
            }
            characterQueue.add(aChar);
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
        }
        return maxLen;
    }

}
