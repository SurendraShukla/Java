package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CountAndSayTest {

    private final CountAndSay countAndSay = new CountAndSay();

    private String callMethod(final int n) {
        return countAndSay.countAndSay(n);
    }

    @Test
    public void test() {
        assertThat(callMethod(1), equalTo("1"));
        assertThat(callMethod(2), equalTo("11"));
        assertThat(callMethod(3), equalTo("21"));
        assertThat(callMethod(4), equalTo("1211"));
        assertThat(callMethod(5), equalTo("111221"));
        assertThat(callMethod(6), equalTo("312211"));
        assertThat(callMethod(7), equalTo("13112221"));
        assertThat(callMethod(8), equalTo("1113213211"));
//        assertThat(callMethod(30), equalTo(""));
    }

}
