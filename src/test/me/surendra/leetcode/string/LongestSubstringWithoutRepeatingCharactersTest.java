package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private int callMethod(final String input) {
        return new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
    }

    @Test
    public void test1() {
        assertThat(callMethod(""), equalTo(0));
        assertThat(callMethod("bbbbb"), equalTo(1));
        assertThat(callMethod("pwwkew"), equalTo(3));
        assertThat(callMethod("abcabcbb"), equalTo(3));
    }

    @Test
    public void test2() {
        assertThat(callMethod("dvdf"), equalTo(3));
    }

    @Test
    public void test3() {
        assertThat(callMethod("aabaab!bb"), equalTo(3));
    }

}
