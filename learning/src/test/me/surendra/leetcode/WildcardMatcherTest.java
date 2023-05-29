package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class WildcardMatcherTest {

    private boolean callMethod(final String aa, final String a) {
        return new WildcardMatcher().isMatch(aa, a);
    }

    @Test
    public void stringWithNoSpecialCharactersDoesNotMatch() {
        assertThat(callMethod("aa", "a"), equalTo(false));
        assertThat(callMethod("a", "aa"), equalTo(false));
    }

    @Test
    public void stringWithNoSpecialCharactersDoesMatch() {
        assertThat(callMethod("aa", "aa"), equalTo(true));
        assertThat(callMethod("a", "a"), equalTo(true));
    }

    @Test
    public void stringWithQuestionMarkDoesMatch() {
        assertThat(callMethod("aa", "a?"), equalTo(true));
        assertThat(callMethod("ab", "a?"), equalTo(true));
        assertThat(callMethod("aa", "?a"), equalTo(true));
        assertThat(callMethod("ca", "?a"), equalTo(true));
    }

    @Test
    public void stringWithAsteriskMarkDoesMatch() {
        assertThat(callMethod("aa", "*"), equalTo(true));
        assertThat(callMethod("aa", "a*"), equalTo(true));
        assertThat(callMethod("adceb", "*a*b"), equalTo(true));
        assertThat(callMethod("aab", "*a*b"), equalTo(true));
        assertThat(callMethod("aab", "*a*a*b"), equalTo(true));
    }

    @Test
    public void stringWithAsteriskMarkDoesNotMatch() {
        assertThat(callMethod("adceb", "*a*d"), equalTo(false));
    }

    @Test
    public void stringWithAsteriskAndQuestionMarkDoesMatch() {
        assertThat(callMethod("adceb", "a*c?b"), equalTo(true));
    }

    @Test
    public void stringWithAsteriskAndQuestionMarkDoesNotMatch() {
        assertThat(callMethod("acdcb", "a*c?b"), equalTo(false));
    }

    @Test
    public void failedOnLeetCode() {
        assertThat(callMethod("","a"), equalTo(false));

        assertThat(callMethod("","******"), equalTo(true));
        assertThat(callMethod("abcabczzzde","*abc???de*"), equalTo(true));
    }


}
