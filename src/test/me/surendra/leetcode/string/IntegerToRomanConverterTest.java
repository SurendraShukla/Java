package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IntegerToRomanConverterTest {

    private final IntegerToRomanConverter integerToRomanConverter = new IntegerToRomanConverter();

    private String callMethod(final int no) {
//        return integerToRomanConverter.intToRoman(no);
        return integerToRomanConverter.intToRomanUsingHardcodeDigits(no);
    }

    @Test
    public void test() {
        assertThat(callMethod(3), equalTo("III"));
        assertThat(callMethod(58), equalTo("LVIII"));
        assertThat(callMethod(1994), equalTo("MCMXCIV"));
        assertThat(callMethod(3999), equalTo("MMMCMXCIX"));
    }

}
