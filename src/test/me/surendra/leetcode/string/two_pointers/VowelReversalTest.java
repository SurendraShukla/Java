package me.surendra.leetcode.string.two_pointers;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class VowelReversalTest {

    private String callMethod(final String hello) {
        return new VowelReversal().reverseVowels(hello);
    }

    @Test
    public void test() {
        assertThat(callMethod("hello"), equalTo("holle"));
        assertThat(callMethod("leetcode"), equalTo("leotcede"));
        assertThat(callMethod("aA"), equalTo("Aa"));
    }

}
