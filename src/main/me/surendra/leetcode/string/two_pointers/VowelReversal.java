package me.surendra.leetcode.string.two_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a String</a>
 */
public class VowelReversal {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public String reverseVowels(String str) {
        final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        final StringBuilder stringBuilder = new StringBuilder(str);
        int leftPointer = 0;
        int rightPointer= stringBuilder.length()-1;

        while(leftPointer < rightPointer) {
            final char leftChar = stringBuilder.charAt(leftPointer);
            final char rightChar = stringBuilder.charAt(rightPointer);
            final boolean leftContainsVowel = vowels.contains(leftChar);
            final boolean rightContainsVowel = vowels.contains(rightChar);
            if(leftContainsVowel && rightContainsVowel) {
                stringBuilder.setCharAt(rightPointer, leftChar);
                stringBuilder.setCharAt(leftPointer, rightChar);
                leftPointer++;
                rightPointer--;
                continue;
            }
            if(!leftContainsVowel) {
                leftPointer++;
            }
            if(!rightContainsVowel) {
                rightPointer--;
            }
        }
        return stringBuilder.toString();
    }

}
