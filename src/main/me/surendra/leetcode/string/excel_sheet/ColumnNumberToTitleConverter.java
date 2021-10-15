package me.surendra.leetcode.string.excel_sheet;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-title/">Excel Sheet Column Title</a>
 */
public class ColumnNumberToTitleConverter {

    /*
        Time Complexity - O(N)
        Space Complexity - O(1)
     */
    public String convertToTitle(int columnNumber) {
        final Map<Integer, Character> numberToAlphabet = new HashMap< >();
        numberToAlphabet.put(0, 'Z');
        for (int i = 0; i < 26; i++) {
            int c = i + 65; // Decimal 65 in ASCII corresponds to char 'A'
            numberToAlphabet.put(i + 1, (char)c);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        while(columnNumber > 26) {
            int tmpNo = columnNumber%26;
            stringBuilder.append(numberToAlphabet.get(tmpNo));
            if (tmpNo == 0) {
                columnNumber--;
            }
            columnNumber = columnNumber/26;
        }
        stringBuilder.append(numberToAlphabet.get(columnNumber));
        return stringBuilder.reverse().toString();
    }

}
