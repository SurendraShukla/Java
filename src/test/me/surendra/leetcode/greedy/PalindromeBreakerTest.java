package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PalindromeBreakerTest {

    private String callMethod(final String aba) {
        return new PalindromeBreaker().breakPalindrome(aba);
    }

    @Test
    public void test() {
        assertThat(callMethod("aba"), equalTo("abb"));
        assertThat(callMethod("bbb"), equalTo("abb"));
        assertThat(callMethod("bbb"), equalTo("abb"));
        assertThat(callMethod("abba"), equalTo("aaba"));
        assertThat(callMethod("abbba"), equalTo("aabba"));
        assertThat(callMethod("abccba"), equalTo("aaccba"));
    }

}
