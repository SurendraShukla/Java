package me.surendra.leetcode.dynamic_programming.hard;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ValidPalindromeIIITest {

    private boolean callMethod(final String abcdeca, final int k) {
        return new ValidPalindromeIII().isValidPalindrome(abcdeca, k);
    }

    @Test
    public void test() {
        assertThat(callMethod("abcdeca", 2), equalTo(true));
        assertThat(callMethod("abbababa", 1), equalTo(true));
        assertThat(callMethod("aaabaabaa", 1), equalTo(true));
        assertThat(callMethod("baaaabaa", 3), equalTo(true));

        assertThat(callMethod("abc", 1), equalTo(false));
    }

}
