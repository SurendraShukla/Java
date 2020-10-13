package me.surendra.leetcode.string;

public class SubStr {
    public static int strStr(String haystack, String needle) {
        final int haystackLen = haystack.length();
        final int needleLen = needle.length();

        if (haystackLen == needleLen) {
            if (haystack.equals(needle)) {
                return 0;
            }
        }

        // 3-1 = 2
        final int strLen = haystackLen - needleLen;
        for (int i = 0; i<= strLen; i++) {
            // 0, 1
            int endIndex = i + needleLen;
            final String subStr = haystack.substring(i, endIndex);
            if (subStr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
