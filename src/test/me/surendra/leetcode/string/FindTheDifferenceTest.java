package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FindTheDifferenceTest {

    private char callMethod(final String str1, final String str2) {
//        return new FindTheDifference().findTheDifference(str1, str2);
        return new FindTheDifference().findTheDifferenceUsingBitMap(str1, str2);
    }

    @Test
    public void test1() {
        assertThat(callMethod("abcd", "abcde"), equalTo('e'));
    }

    @Test
    public void test2() {
        assertThat(callMethod("", "y"), equalTo('y'));
    }

    @Test
    public void test3() {
        assertThat(callMethod("a", "aa"), equalTo('a'));
    }

    @Test
    public void test4() {
        assertThat(callMethod("ae", "aea"), equalTo('a'));
    }

}
