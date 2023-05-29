package me.surendra.leetcode.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 */
public class AllAnagramFinder {

    /*
        Time complexity: O(Ns1 + Ns2) i.e. (s1.length + s2.length)
        Space complexity: O(1) i.e. O(pCount + sCount)
     */
    public List<Integer> findAnagramsUsingSlidingWindow(final String mainStr, final String searchStr) {
        final int mainStrLen = mainStr.length();
        final int searchStrLen = searchStr.length();

        final int[] searchChars = new int[26];
        for (int i=0; i<searchStrLen; i++) {
            searchChars[searchStr.charAt(i) - 'a']++;
        }

        final List<Integer> returnList = new ArrayList<>();
        final int[] slidingWindowChars = new int[26];
        for (int i=0; i<mainStrLen; i++) {
            // Add element at right
            slidingWindowChars[mainStr.charAt(i) - 'a']++;
            // Sliding Window should not keep more than Search String Length
            // If current index is greater than searchStrLen, Remove element from left
            if (i >= searchStrLen) {
                final int charRemovalIndex = i-searchStrLen;
                // To remove element from left
                slidingWindowChars[mainStr.charAt(charRemovalIndex) - 'a']--;
            }
            if(Arrays.equals(searchChars, slidingWindowChars)) {
                returnList.add(i-searchStrLen+1);
            }
        }

        return returnList;
    }

}
