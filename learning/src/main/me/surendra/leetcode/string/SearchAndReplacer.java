package me.surendra.leetcode.string;

public class SearchAndReplacer {

    /*
        Time Complexity - n*m
        Space Complexity - n*m
     */
    public static String searchAndReplace(final String mainStr,
                                          final String searchStr,
                                          final String replaceStr
    ) {

        final int mainStrLength = mainStr.length();
        final int searchStrLength = searchStr.length();
        final StringBuilder result = new StringBuilder();
        for (int i=0; i<mainStrLength; ) {
            if (isKeyStartsAt(mainStr, searchStr, i, mainStrLength, searchStrLength)) {
                result.append(replaceStr);
                i += searchStrLength;
            } else {
                result.append(mainStr.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    private static boolean isKeyStartsAt(final String mainStr,
                                         final String searchStr,
                                         final int startIndex,
                                         final int mainStrLength,
                                         final int searchStrLength
    ) {
        int strEnd = startIndex + searchStrLength;
        if (strEnd > mainStrLength ) {
            return false;
        }

        for (int i=startIndex, j=0; i<strEnd; i++, j++) {
            if (mainStr.charAt(i) != searchStr.charAt(j)) {
                return false;
            }
        }

        return true;
    }

}
