package me.surendra.leetcode.string.anagram;

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String searchStr, String mainString) {
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
