package me.surendra.leetcode.string;

/**
 * @see <a href="https://leetcode.com/problems/find-the-difference/">Find the Difference</a>
 */
public class FindTheDifference {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public char findTheDifference(String s, String t) {
        final int[] charFrequency = new int[26];
        for (int i = 0; i < t.length(); i++) {
            charFrequency[t.charAt(i) - 'a']++;
        }
        for (int j = 0; j < s.length(); j++) {
            charFrequency[s.charAt(j) - 'a']--;
        }
        char returnChar = 'a';
        for (int k = 0; k < charFrequency.length; k++) {
            if(charFrequency[k] != 0) {
                returnChar = (char) (k + 97);
                break;
            }
        }
        return returnChar;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public char findTheDifferenceUsingBitMap(String s, String t) {
        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        char returnChar = 0;

        // XOR all the characters of both s and t.
        for (int i = 0; i < t.length(); i++) {
            returnChar^=t.charAt(i);
        }
        for (int j = 0; j < s.length(); j++) {
            returnChar^=s.charAt(j);
        }

        // What is left after XORing everything is the difference.
        return returnChar;
    }

}
