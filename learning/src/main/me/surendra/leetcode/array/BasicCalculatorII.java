package me.surendra.leetcode.array;


/**
 * @see <a href="https://leetcode.com/problems/basic-calculator-ii/">Basic Calculator II</a>
 */
public class BasicCalculatorII {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public int calculate(String s) {
        int idx=0;
        int result = getNumericValue(s.charAt(idx++));
        while(idx<s.length()) {
            char aChar = s.charAt(idx);
            switch(aChar) {
                case ' ':
                    break;
                case '+':
                    result+=getNumericValue(s.charAt(++idx));
                    break;
                case '-':
                    result-=getNumericValue(s.charAt(++idx));
                    break;
                case '*':
                    result*=getNumericValue(s.charAt(++idx));
                    break;
                case '/':
                    result/=getNumericValue(s.charAt(++idx));
            }
            idx++;
        }
        return result;
    }

    private int getNumericValue(final char c) {
        return Character.getNumericValue(c);
    }

}
