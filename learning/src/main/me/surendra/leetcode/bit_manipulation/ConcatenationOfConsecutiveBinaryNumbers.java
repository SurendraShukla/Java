package me.surendra.leetcode.bit_manipulation;

/**
 * @see <a href="https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/">Concatenation of Consecutive Binary Numbers</a>
 */
public class ConcatenationOfConsecutiveBinaryNumbers {

    final static int MOD = 1000000007;


    /**
     Time complexity: O(n),
            Iterate over n numbers, and for each number we spend O(1) to add it to the final result.
     Space complexity: O(1)
            Do not need any extra data structure.
     */
    public int concatenatedBinaryUsingBitManipulation(final int n) {
        /*
            Iterate from 1 to n. For each number i:
                Find the length of the binary representation of the number. Denote by length.
                    If no is the power of 2, then increment length
                Update result to result << length | i.
                    After shifting number by length position.
                    Add/concat (|) current no to result
         */
        int length = 0; // bit length of addends
        long result = 0; // long accumulator
        for (int i = 1; i <= n; i++) {
            // when meets power of 2, increase the bit length
            if ((i & (i - 1)) == 0) {
                length++;
            }
            result = ((result << length) | i) % MOD;
        }
        return (int) result;
    }

    /**
        Time complexity: O (n log (n)),
             Iterate over n numbers.
             For each number we spend O(log(n)) to transform it into the binary form
             and add it to the final result.
        Space complexity: O(n)
                To add the string into the final result.
     */
    public int concatenatedBinary(final int n) {
        /*
            Iterate from 1 to n. For each number:
                Convert the number into binary form.
                Iterate the binary string. For each element (0 or 1),
                    update result to 2*result + element.
         */
        int result = 0;
        for (int i = 1; i <= n; i++) {
            final String noBinaryRepresentation = Integer.toBinaryString(i);
            for (char aChar: noBinaryRepresentation.toCharArray()) {
                result = ((result * 2) + (aChar - '0')) % MOD;
            }
        }
        return result;
    }


}
