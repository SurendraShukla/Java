package me.surendra.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
 */
public class RomanToIntegerConverter {

    /*
        Time complexity : O(1) The same number of operations is done, regardless of the size of the input.
        Space complexity: O(1)
     */
    static Map<String, Integer> allPossibleRomanSymbolMap = new HashMap<>();
    static {
        allPossibleRomanSymbolMap.put("I", 1);
        allPossibleRomanSymbolMap.put("V", 5);
        allPossibleRomanSymbolMap.put("X", 10);
        allPossibleRomanSymbolMap.put("L", 50);
        allPossibleRomanSymbolMap.put("C", 100);
        allPossibleRomanSymbolMap.put("D", 500);
        allPossibleRomanSymbolMap.put("M", 1000);
        allPossibleRomanSymbolMap.put("IV", 4);
        allPossibleRomanSymbolMap.put("IX", 9);
        allPossibleRomanSymbolMap.put("XL", 40);
        allPossibleRomanSymbolMap.put("XC", 90);
        allPossibleRomanSymbolMap.put("CD", 400);
        allPossibleRomanSymbolMap.put("CM", 900);
    }
    public int romanToIntUsingLeftToRightPass(final String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                final String doubleSymbol = s.substring(i, i + 2);
                // Check if this is the length-2 symbol case.
                if (allPossibleRomanSymbolMap.containsKey(doubleSymbol)) {
                    sum += allPossibleRomanSymbolMap.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            final String singleSymbol = s.substring(i, i + 1);
            sum += allPossibleRomanSymbolMap.get(singleSymbol);
            i += 1;
        }
        return sum;
    }

    /*
            Time complexity : O(1) The same number of operations is done, regardless of the size of the input.
            Space complexity: O(1)
         */
    static Map<String, Integer> romanSymbolMap = new HashMap<>();
    static {
        romanSymbolMap.put("I", 1);
        romanSymbolMap.put("V", 5);
        romanSymbolMap.put("X", 10);
        romanSymbolMap.put("L", 50);
        romanSymbolMap.put("C", 100);
        romanSymbolMap.put("D", 500);
        romanSymbolMap.put("M", 1000);
    }
    public int romanToIntByRightToLeftPass(final String s) {
        final String lastSymbol = s.substring(s.length() - 1);
        int lastValue = romanSymbolMap.get(lastSymbol);
        int total = lastValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            final String currentSymbol = s.substring(i, i + 1);
            final int currentValue = romanSymbolMap.get(currentSymbol);
            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }


    /*
        Time complexity : O(1) The same number of operations is done, regardless of the size of the input.
        Space complexity: O(1)
     */
    private static final int[] values = {1000,  900,  500,  400,  100,  90,  50,  40,  10,  9,  5,  4,  1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int no = 0;
    String str;
    int startIdx = 0;
    public int romanToInt(final String s) {
        str = s;
        for (int i = 0; i < symbols.length; i++) {
            populate(symbols[i], i);
        }
        return no;
    }

    private void populate(final String symbol, final int idx) {
        if (startIdx >= str.length()) {
            return;
        }
        if (!str.startsWith(symbol)) {
            return;
        }
        final int endIdx = Math.min(startIdx + symbol.length(), str.length());
        final String subString = str.substring(startIdx, endIdx);
        if (!symbol.equals(subString)) {
            return;
        }
        no += values[idx];
        startIdx += symbol.length();
        populate(symbol, idx);
    }


}
