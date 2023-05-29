package me.surendra.leetcode.bit_manipulation;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConcatenationOfConsecutiveBinaryNumbersTest {

    private ConcatenationOfConsecutiveBinaryNumbers concatenationOfConsecutiveBinaryNumbers = new ConcatenationOfConsecutiveBinaryNumbers();

    private int callMethod(final int n) {
//        return concatenationOfConsecutiveBinaryNumbers.concatenatedBinary(n);
        return concatenationOfConsecutiveBinaryNumbers.concatenatedBinaryUsingBitManipulation(n);
    }

    @Test
    public void test() {
        assertThat(callMethod(1), equalTo(1));
        assertThat(callMethod(2), equalTo(6));
        assertThat(callMethod(3), equalTo(27));
        assertThat(callMethod(12), equalTo(505379714));
    }

    @Test
    public void rangeTest() {
        assertThat(callMethod(100000), equalTo(757631812));
    }
}
