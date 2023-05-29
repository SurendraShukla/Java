package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/encode-and-decode-strings/"></a>
 */
public class EncodeAndDecode {

    final static String NEW_LINES = "\01";
    final static String TABS = "\03";
    final static String DELIMINATORS = "\04";
    final static String EMPTY_STRING = "\05";

    // Encodes a list of strings to a single string.
    public String encode(final List<String> strs) {
        final StringBuilder encodedString = new StringBuilder();
        for (String str: strs) {
            encodedString.append(encodeByCountAndSayAlog(str));
            encodedString.append(NEW_LINES);
        }
        return encodedString.toString();
    }

    private String encodeByCountAndSayAlog(final String str) {
        if ("".equals(str)) {
            return EMPTY_STRING;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        Character previousChar = str.charAt(0);
        int countAppearance = 1;
        for (int charIndex = 1; charIndex < str.length(); charIndex++) {
            final char aChar = str.charAt(charIndex);
            if (aChar == previousChar) {
                countAppearance++;
            } else {
                stringBuilder.append(countAppearance + TABS + previousChar + DELIMINATORS);
                countAppearance = 1;
                previousChar = aChar;
            }
        }
        stringBuilder.append(countAppearance + TABS + previousChar + DELIMINATORS);
        return stringBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(final String s) {
        final String[] encodedStrings = s.split(NEW_LINES);
        final List<String> strings = new ArrayList<>();
        for (String str: encodedStrings) {
            strings.add(decodedString(str));
        }
        return strings;
    }

    private String decodedString(final String str) {
        if (EMPTY_STRING.equals(str)) {
            return "";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        final String[] charsFrequency = str.split(DELIMINATORS);
        for (String charFrequency: charsFrequency) {
            final String[] charInfo = charFrequency.split(TABS);
            final int count = Integer.valueOf(charInfo[0]);
            for (int i = 1; i <= count; i++) {
                stringBuilder.append(charInfo[1]);
            }
        }
        return stringBuilder.toString();
    }

}
