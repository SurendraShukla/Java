package me.surendra.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a>
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if (dividend < -2147483647) {
            if (divisor < 0) {
                return 2147483647;
            }
            return -2147483648;
        }

        int multiplier = 1;
        if (dividend < 0 && divisor < 0) {
            dividend*=-1;
            divisor*=-1;
            multiplier = 1;
        }else if ((dividend < 0) || (divisor < 0)) {
            if (dividend < 0) {
                dividend*=-1;
            }else{
                divisor*=-1;
            }
            multiplier = -1;
        }

        int quotient = 0;

        while(dividend >= divisor) {
            quotient++;
            dividend-=divisor;
        }
        return quotient * multiplier;
    }

}
