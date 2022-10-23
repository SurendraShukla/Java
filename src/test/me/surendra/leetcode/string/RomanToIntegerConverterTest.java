package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RomanToIntegerConverterTest {

    private final RomanToIntegerConverter romanToIntegerConverter = new RomanToIntegerConverter();

    private int callMethod(final String str) {
//        return romanToIntegerConverter.romanToInt(str);
//        return romanToIntegerConverter.romanToIntUsingLeftToRightPass(str);
        return romanToIntegerConverter.romanToIntByRightToLeftPass(str);
    }

    @Test
    public void test() {
        assertThat(callMethod("III"), equalTo(3));
        assertThat(callMethod("LVIII"), equalTo(58));
        assertThat(callMethod("DCXXI"), equalTo(621));
        assertThat(callMethod("MCMXCIV"), equalTo(1994));
        assertThat(callMethod("MMMCMXCIX"), equalTo(3999));
    }

}
