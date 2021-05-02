package me.surendra.leetcode.string;

public class SearchAndReplace {

    public static String searchAndReplace(final String mainStr, final String searchStr, final String replaceStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mainStr.length(); ) {
            if (isKeyStartsAt(mainStr, searchStr, i)) {
                result.append(replaceStr);
                i += searchStr.length();
            } else {
                result.append(mainStr.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    private static boolean isKeyStartsAt(final String mainStr, final String searchStr, final int s) {
        int i = 0;
        for (; i < searchStr.length() && (s + i) < mainStr.length(); i++) {
            if (searchStr.charAt(i) != mainStr.charAt(s + i))
                return false;
        }
        if (i < searchStr.length()) {
            return false;
        }
        return true;
    }
}
