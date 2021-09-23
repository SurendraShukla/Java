package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ExcelSheetTest {

    private int callMethod(final String str) {
//        return new ExcelSheet().titleToNumber(str);
        return new ExcelSheet().titleToNumberUsingLeftToRightApproach(str);
    }

    @Test
    public void singleDigital() {
        assertThat(callMethod("A"), equalTo(1));
        int val = 1;

        for (char ch='A'; ch <= 'Z'; ++ch, val++) {
            assertThat(callMethod(String.valueOf(ch)), equalTo(val));
        }
    }

    @Test
    public void doubleDigital() {
        assertThat(callMethod("AA"), equalTo(27));
        assertThat(callMethod("AB"), equalTo(28));
        assertThat(callMethod("AZ"), equalTo(52));

        assertThat(callMethod("BA"), equalTo(53));
        assertThat(callMethod("BZ"), equalTo(78));

        assertThat(callMethod("CA"), equalTo(79));
        assertThat(callMethod("ZZ"), equalTo(702));
    }

    @Test
    public void tripleDigital() {
        assertThat(callMethod("AAA"), equalTo(703));
        assertThat(callMethod("BAA"), equalTo(1379));

        assertThat(callMethod("ZZZ"), equalTo(18278));
    }

    @Test
    public void multipleDigital() {
        assertThat(callMethod("FXSHRXW"), equalTo(2147483647));
    }

}
