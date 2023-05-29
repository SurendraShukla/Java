package me.surendra.leetcode.recursion;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReverseStringTest {

    @Test
    public void shouldReverseEmptyString() {
        actAndAssert(new char[]{}, new char[]{});
    }

    @Test
    public void shouldReverseSingleCharString() {
        actAndAssert(new char[]{'h'}, new char[]{'h'});
    }

    @Test
    public void shouldReverseHelloString() {
        final char[] chars = {'h', 'e', 'l', 'l', 'o'};
        final char[] expectedChars = {'o','l','l','e','h'};

        actAndAssert(chars, expectedChars);
    }

    @Test
    public void shouldReverseHannahString() {
        final char[] chars = {'H','a','n','n','a','h'};
        final char[] expectedChars = {'h','a','n','n','a','H'};

        actAndAssert(chars, expectedChars);
    }

    private void actAndAssert(final char[] chars, final char[] expectedChars) {
        ReverseString.reverseString(chars);

        assertThat(chars, equalTo(expectedChars));
    }

}
