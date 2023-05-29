package me.surendra.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/reverse-bits/"></a>
 */
public class BitReverser {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int reverseBits(int n) {
        int counter = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        while(n > 0) {
            stringBuilder.append(n % 2);
            counter++;
            n/=2;
        }
        for (int i = counter; i < 32; i++) {
            stringBuilder.append(0);
        }
        long l = Long.parseLong(stringBuilder.toString(), 2);
        return (int)l;
    }

}
