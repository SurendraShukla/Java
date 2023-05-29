package me.surendra.leetcode.string.excel_sheet;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-number/">Excel Sheet Column Number</a>
 */
public class ColumnTitleToNumberConverter {

    /*
        Time Complexity - O(N)
        Space Complexity - O(1)

        Right to Left Approach
     */
    public int titleToNumberUsingRightToLeftApproach(final String columnTitle) {
//        final Map<Character, Integer> alphabetToNumber = new HashMap<>();
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().forEach(ch -> alphabetToNumber.put((char) ch, ch - 'A' + 1));

        final Map<Character, Integer> alphabetToNumber = new HashMap < > ();
        for (int i = 0; i < 26; i++) {
            int c = i + 65; // Decimal 65 in ASCII corresponds to char 'A'
            alphabetToNumber.put((char) c, i + 1);
        }

        int result = 0;
        int strLen = columnTitle.length();

        for(char aChar : columnTitle.toCharArray()) {
            result+= (Math.pow(26, strLen-1)* alphabetToNumber.get(aChar));
            strLen--;
        }

        return result;
    }

    /*
        Time Complexity - O(N)
        Space Complexity - O(1)

        Left to Right Approach
            We are dealing with base-26 number system.

            For a title "LEET":
            L = 12
            E = (12 x 26) + 5 = 317
            E = (317 x 26) + 5 = 8247
            T = (8247 x 26) + 20 = 214442
     */
    public int titleToNumberUsingLeftToRightApproach(String s) {

        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result = result * 26;
            // In Java, subtracting characters is subtracting ASCII values of characters
            result += (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

}
