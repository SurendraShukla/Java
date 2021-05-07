package me.surendra.leetcode.string;

import me.surendra.leetcode.string.palindrome.Palindrome;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PalindromeTest {

    @Test
    public void validPalindromeStringHavingOddLength() {
        assertThat(Palindrome.validPalindrome("aba"), equalTo(true));
    }

    @Test
    public void validPalindromeStringHavingEvenLength() {
        assertThat(Palindrome.validPalindrome("abba"), equalTo(true));
    }

    @Test
    public void validPalindromeAfterRemovingFromStringHavingOddLength() {
        assertThat(Palindrome.validPalindrome("abbac"), equalTo(true));
    }

    @Test
    public void validPalindromeAfterRemovingFromStringHavingEvenLength() {
        assertThat(Palindrome.validPalindrome("abba"), equalTo(true));
    }

    @Test
    public void inValidPalindromeAfterRemovingFromStringHavingOddLength() {
        assertThat(Palindrome.validPalindrome("abbca"), equalTo(true));
    }

    @Test
    public void inValidPalindromeAfterRemovingFromStringHavingEvenLength() {
        assertThat(Palindrome.validPalindrome("abbba"), equalTo(true));
    }

}
