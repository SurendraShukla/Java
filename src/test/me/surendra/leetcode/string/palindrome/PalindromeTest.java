package me.surendra.leetcode.string.palindrome;

import me.surendra.leetcode.string.palindrome.Palindrome;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PalindromeTest {

    private boolean callMethod(final String str) {
//        return new Palindrome().isValidPalindrome_BruteForceAlgoUsesSubString(str);
//        return new Palindrome().isValidPalindrome_BruteForceUsesStringBuilder(str);
        return new Palindrome().isValidPalindrome_2PointerApproach(str);
    }

    @Test
    public void validPalindromeStringHavingOddLength1() {
        assertThat(callMethod("abc"), equalTo(false));
    }

    @Test
    public void validPalindromeStringHavingOddLength() {
        assertThat(callMethod("aba"), equalTo(true));
    }

    @Test
    public void validPalindromeStringHavingEvenLength() {
        assertThat(callMethod("abba"), equalTo(true));
    }

    @Test
    public void validPalindromeAfterRemovingFromStringHavingOddLength() {
        assertThat(callMethod("abbac"), equalTo(true));
    }

    @Test
    public void validPalindromeAfterRemovingFromStringHavingEvenLength() {
        assertThat(callMethod("abba"), equalTo(true));
    }

    @Test
    public void inValidPalindromeAfterRemovingFromStringHavingOddLength() {
        assertThat(callMethod("abbca"), equalTo(true));
    }

    @Test
    public void inValidPalindromeAfterRemovingFromStringHavingEvenLength() {
        assertThat(callMethod("abbba"), equalTo(true));
    }

}
