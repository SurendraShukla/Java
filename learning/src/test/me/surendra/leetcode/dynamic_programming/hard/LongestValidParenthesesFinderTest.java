package me.surendra.leetcode.dynamic_programming.hard;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LongestValidParenthesesFinderTest {

    private int callMethod(final String s) {
//        return new LongestValidParenthesesFinder().longestValidParenthesesUsingStack(s);
        return new LongestValidParenthesesFinder().longestValidParenthesesBothDirection(s);
    }

    @Test
    public void test1() {
        assertThat(callMethod(""), equalTo(0));
        assertThat(callMethod("(()"), equalTo(2));
        assertThat(callMethod(")()())"), equalTo(4));
        assertThat(callMethod("(()()"), equalTo(4));
        assertThat(callMethod("(()())"), equalTo(6));
        assertThat(callMethod("(()())()"), equalTo(8));
        assertThat(callMethod("(((((((()"), equalTo(2));

        assertThat(callMethod("("), equalTo(0));
        assertThat(callMethod("()(()"), equalTo(2));
        assertThat(callMethod("()(()()"), equalTo(4));
        assertThat(callMethod("()(()()"), equalTo(4));
    }

}
