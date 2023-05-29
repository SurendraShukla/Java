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
        final StringBuilder stringBuilder = new StringBuilder();
        while(columnNumber != 0) {
            int no = columnNumber % 26;
            if (no == 0) {
                no = 26;
                columnNumber--;
            }
            char ch = (char)(64 + no);
            stringBuilder.append(ch);
            columnNumber/=26;
        }
        return stringBuilder.reverse().toString();
    }

}
