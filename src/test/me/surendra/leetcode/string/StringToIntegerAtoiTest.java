package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StringToIntegerAtoiTest {

    private int callMethod(final String str) {
        return new StringToIntegerAtoi().myAtoi(str);
    }

    @Test
    public void regularNumber() {
        assertThat(callMethod("1"), equalTo(1));
        assertThat(callMethod("42"), equalTo(42));
    }

    @Test
    public void numberWithSign() {
        assertThat(callMethod("+"), equalTo(0));
        assertThat(callMethod("+1"), equalTo(1));
        assertThat(callMethod("   -42"), equalTo(-42));
        assertThat(callMethod("-01324000"), equalTo(-1324000));
    }

    @Test
    public void numberWithString() {
        assertThat(callMethod("4193 with words"), equalTo(4193));
        assertThat(callMethod("words and 987"), equalTo(0));
        assertThat(callMethod("   -1123u3761867"), equalTo(-1123));
    }

    @Test
    public void numberOutOfRange() {
        assertThat(callMethod("-91283472332"), equalTo(-2147483648));
    }

}
