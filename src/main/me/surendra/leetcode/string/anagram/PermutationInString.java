package me.surendra.leetcode.string.anagram;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/permutation-in-string/">Permutation in String</a>
 */
public class PermutationInString {

    /*
        Time Complexity - O(l1 + 26 * l1 * (l2-l1) ). l1 is the length of string l1, l1 is the length of string l2
        Space Complexity - O(1). s1map and s2map of size 26 is used.
     */
    public boolean checkInclusionByUsingIntArray(String searchStr, String mainStr) {
        final int[] searchCharArray = new int[26];
        final int searchStrLength = searchStr.length();
        final int mainStrLength = mainStr.length();

        for (int i = 0; i < searchStrLength; i++) {
            searchCharArray[searchStr.charAt(i) - 'a']++;
        }

        for (int j = 0; j <= mainStrLength - searchStrLength; j++) {
            final int[] tmpCharArray = new int[26];
            for (int k = 0; k < searchStrLength; k++) {
                tmpCharArray[mainStr.charAt(j+k) - 'a']++;
            }
            if (charArrayIsSame(searchCharArray, tmpCharArray)) {
                return true;
            }
        }
        return false;
    }

    private boolean charArrayIsSame(final int[] searchCharArray, final int[] tmpCharArray) {
        for(int i=0; i<searchCharArray.length; i++) {
            if (searchCharArray[i] != tmpCharArray[i]) {
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity - O( l1log(l1) + (l2-l1)l1log(l1) ). l1 is the length of string l1, l1 is the length of string l2
        Space Complexity - O(l1)
     */
    public boolean checkInclusionByUsingString(String searchStr, String mainStr) {
        final int searchStrLength = searchStr.length();
        final int mainStrLength = mainStr.length();

        final char[] sortedSearchStr = sortString(searchStr);

        for (int i = 0; i <= mainStrLength-searchStrLength; i++) {
            final char[] sortedSubString = sortString(mainStr.substring(i, i+searchStrLength));
            if(Arrays.equals(sortedSearchStr, sortedSubString)) {
                return true;
            }
        }
        return false;
    }

    // Method to sort a string alphabetically
    public static char[] sortString(String inputString) {

        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return tempArray;
    }

    /*
        Time Complexity - O( l1log(l1) + (l2-l1)l1log(l1) ). l1 is the length of string l1, l1 is the length of string l2
        Space Complexity - O(l1)
     */
    public boolean checkInclusionByUsingCharArray(String searchStr, String mainString) {
        final char[] searchChars = searchStr.toCharArray();
        final char[] mainChars = mainString.toCharArray();
        final int searchLength = searchChars.length;

        Arrays.sort(searchChars);

        for (int i = 0; i <= mainChars.length-searchLength; i++) {
            char[] charArrayForPermutationCheck = getCharArrayForPermutationCheck(i, searchLength, mainChars);
            if(Arrays.equals(charArrayForPermutationCheck, searchChars)) {
                return true;
            }
        }
        return false;
    }

    private char[] getCharArrayForPermutationCheck(final int startIndex, final int length, final char[] mainChars) {
        char[] returnChar = new char[length];
        for(int i=startIndex, j=0; i<startIndex+length; i++, j++) {
            returnChar[j] = mainChars[i];
        }
        Arrays.sort(returnChar);
        return returnChar;
    }

}
