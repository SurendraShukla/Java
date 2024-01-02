package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DecodeWaysTest {

    private static int callMethod(final String number) {
        final DecodeWays decodeWays = new DecodeWays();
        return decodeWays.numDeCodings(number);
    }

    @Test
    public void test() {
        assertThat(callMethod("12"), equalTo(2));
        assertThat(callMethod("226"), equalTo(3));
        assertThat(callMethod("27"), equalTo(1));

        assertThat(callMethod("06"), equalTo(0));
        assertThat(callMethod("0"), equalTo(0));
    }

}
