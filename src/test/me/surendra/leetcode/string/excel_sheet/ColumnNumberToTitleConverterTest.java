package me.surendra.leetcode.string.excel_sheet;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ColumnNumberToTitleConverterTest {

    private String callMethod(final int columnNumber) {
        return new ColumnNumberToTitleConverter().convertToTitle(columnNumber);
    }

    @Test
    public void singleDigital() {
        assertThat(callMethod(0), equalTo(String.valueOf('Z')));

        int val = 1;
        for (char ch='A'; ch < 'Z'; ++ch, val++) {
            assertThat(callMethod(val), equalTo(String.valueOf(ch)));
        }
    }

    @Test
    public void doubleDigital() {
        assertThat(callMethod(27), equalTo("AA"));
        assertThat(callMethod(28), equalTo("AB"));
        assertThat(callMethod(52), equalTo("AZ"));

        assertThat(callMethod(53), equalTo("BA"));
        assertThat(callMethod(78), equalTo("BZ"));

        assertThat(callMethod(79), equalTo("CA"));
        assertThat(callMethod(702), equalTo("ZZ"));
    }

    @Test
    public void tripleDigital() {
        assertThat(callMethod(703), equalTo("AAA"));
        assertThat(callMethod(1379), equalTo("BAA"));
        assertThat(callMethod(18278), equalTo("ZZZ"));
    }

    @Test
    public void multipleDigital() {
        assertThat(callMethod(2147483647), equalTo("FXSHRXW"));
    }

}
