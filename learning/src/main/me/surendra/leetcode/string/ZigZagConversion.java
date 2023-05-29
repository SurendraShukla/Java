package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">ZigZag Conversion</a>
 */
public class ZigZagConversion {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)

        Sort by Row
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        final int strLen = s.length();
        final List<StringBuilder> strings = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            strings.add(row, new StringBuilder());
        }
        int rowCounter = 0;
        boolean goingDown = false;
        for (int charCounter = 0; charCounter < strLen; charCounter++) {
            strings.get(rowCounter).append(s.charAt(charCounter));
            if ((rowCounter == 0) || (rowCounter == numRows-1)) {
                goingDown = !goingDown;
            }
            rowCounter+= goingDown ?  1 : -1;
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (final StringBuilder characterList : strings) {
            stringBuilder.append(characterList.toString());
        }
        return stringBuilder.toString();
    }

}
