package me.surendra.leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/happy-number/">Happy Number</a>
 */
public class HappyNumber {

    /*
        Time Complexity - O(log n)
        Space Complexity - O(log n)
     */
    public boolean isHappy(int n) {
        final Set<Integer> digits = new HashSet<>();
        while(n != 1 && !digits.contains(n)) {
            digits.add(n);
            n = getNumber(n);
        }
        return n ==1;
    }

    private int getNumber(int n) {
        int totalSum = 0;
        while(n > 0) {
            int remainder = n %10;
            totalSum+= remainder*remainder;
            n = n /10;
        }
        return totalSum;
    }

}
