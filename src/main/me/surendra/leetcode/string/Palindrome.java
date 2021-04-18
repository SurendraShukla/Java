package me.surendra.leetcode.string;

public class Palindrome {

    /**
     * @param  str string
     * @return boolean
     *
     * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome</a>
     */
    public static boolean validPalindrome(final String str) {
        int[] charsCount = new int[26];
        for(char c : str.toCharArray()) {
            charsCount[c-'a']++;
        }
        int charsWithOddCount = 0;
        for (int i=0; i<charsCount.length; i++) {
            if (charsCount[i] % 2 != 0) {
                charsWithOddCount++;
            }
        }
        if (charsWithOddCount > 2) {
            return false;
        }
        return true;
    }

}
