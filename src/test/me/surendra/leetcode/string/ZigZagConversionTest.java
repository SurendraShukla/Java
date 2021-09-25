package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ZigZagConversionTest {

    @Test
    public void singleRowSingleChar() {
        final String zigZagString = new ZigZagConversion().convert("A", 1);

        assertThat(zigZagString, equalTo("A"));
    }

    @Test
    public void singleRowMultipleChar() {
        final String zigZagString = new ZigZagConversion().convert("AB", 1);

        assertThat(zigZagString, equalTo("AB"));
    }

    @Test
    public void threeRowsMultipleChars() {
        char[] chars = "PAYPALISHIRING".toCharArray();
        System.out.println(chars);

        final String zigZagString = new ZigZagConversion().convert("PAYPALISHIRING", 3);

        assertThat(zigZagString, equalTo("PAHNAPLSIIGYIR"));
    }

    @Test
    public void fourRowsMultipleChars() {
        final String zigZagString = new ZigZagConversion().convert("PAYPALISHIRING", 4);

        assertThat(zigZagString, equalTo("PINALSIGYAHRPI"));
    }


}
