package me.surendra.leetcode.string;

/**
 * @see <a href="">Find the Index of the First Occurrence in a String</a>
 */
public class FirstOccurrenceIndexFinder {

    /*
        Time Complexity - O(n * m) N is length haystack, M is length needle
        Space Complexity - 0(1)
     */
    public int strStr(final String haystack, final String needle) {
        final int needleLen = needle.length();
        final int haystackLen = haystack.length();
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            if (needle.equals(haystack.substring(i, i + needleLen))) {
                return i;
            }
        }
        return -1;
    }

}
