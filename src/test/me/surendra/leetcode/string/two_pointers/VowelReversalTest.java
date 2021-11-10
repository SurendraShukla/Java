package me.surendra.leetcode.string.two_pointers;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


public class VowelReversalTest {

    private String callMethod(final String hello) {
        return new VowelReversal().reverseVowels(hello);
    }

    @Test
    public void test() {
        Assert.assertThat(callMethod("hello"), Matchers.equalTo("holle"));
        Assert.assertThat(callMethod("leetcode"), Matchers.equalTo("leotcede"));
        Assert.assertThat(callMethod("aA"), Matchers.equalTo("Aa"));
    }

}
