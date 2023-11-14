package me.surendra.leetcode.prefix_sum;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class Unique3LengthPalindromicSubsequencesTest {

    private final Unique3LengthPalindromicSubsequences unit = new Unique3LengthPalindromicSubsequences();

    private int callMethod(final String aabca1) {
        return unit.countPalindromicSubsequence(aabca1);
    }

    @Test
    public void test() {
        assertThat(callMethod("aabca"), equalTo(3));
        assertThat(callMethod("adc"), equalTo(0));
        assertThat(callMethod("bbcbaba"), equalTo(4));
    }

}
