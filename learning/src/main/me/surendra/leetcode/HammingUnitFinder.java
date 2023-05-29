package me.surendra.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/hamming-distance/">Hamming Distance</a>
 */
public class HammingUnitFinder {

    /*
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public int hammingDistanceUsingBitCountMethod(final int x, final int y) {
        return Integer.bitCount(x ^ y);
    }

    /*
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public int hammingDistanceUsingBitShift(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1) { // Remainder check
                distance += 1;
            }
            xor = xor >> 1; // Divide operation
        }
        return distance;
    }

    /*
        Time complexity: O(1)
        Space complexity: O(1)

        AND bit operation between number and number-1,
        the rightmost bit of one in the original number would be cleared.
     */
    public int hammingDistanceUsingBrianKernighanAlgorithm(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor &= (xor - 1);
        }
        return distance;
    }

    /*
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public int hammingDistance(final int x, final int y) {
        final Long oneCounts = Arrays
            .stream(Integer.toBinaryString(x ^ y).split(""))
            .filter(no -> no.equals("1"))
            .count();
        return oneCounts.intValue();
    }

    /*
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /*
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public int hammingWeightUsingBrianKernighanAlgorithm(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
