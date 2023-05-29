package me.surendra.leetcode.string.palindrome;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestPalindromeFinderTest {

    private int callMethod(final String input) {
        return new LongestPalindromeFinder().longestPalindrome(input);
//        return new LongestPalindromeFinder().longestPalindromeUsingCharArray(input);
    }

    @Test
    public void test1() {
        assertThat(callMethod("abccccddeeefff"), equalTo(11));
        assertThat(callMethod("abccccdd"), equalTo(7));
        assertThat(callMethod("a"), equalTo(1));
        assertThat(callMethod("bb"), equalTo(2));
        assertThat(callMethod("ccc"), equalTo(3));
    }

}
