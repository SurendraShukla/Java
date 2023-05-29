package me.surendra.leetcode.greedy;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MakeParenthesesValidTest {

    private int callMethod(final String str) {
        return new MakeParenthesesValid().minAddToMakeValid(str);
    }

    @Test
    public void invalidString() {
        assertThat(callMethod("("), equalTo(1));
        assertThat(callMethod(")"), equalTo(1));
        assertThat(callMethod("())"), equalTo(1));
        assertThat(callMethod("((("), equalTo(3));
        assertThat(callMethod("()))(("), equalTo(4));
    }

    @Test
    public void validString() {
        assertThat(callMethod(""), equalTo(0));
        assertThat(callMethod("()"), equalTo(0));
    }

}
