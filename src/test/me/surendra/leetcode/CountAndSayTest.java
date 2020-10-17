package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CountAndSayTest {

    @Test
    public void countAndSaySequenceForInt1() {
        assertThat(CountAndSay.countAndSay(1), equalTo("1"));
    }

    @Test
    public void countAndSaySequenceForInt2() {
        assertThat(CountAndSay.countAndSay(2), equalTo("11"));
    }

    @Test
    public void countAndSaySequenceForInt3() {
        assertThat(CountAndSay.countAndSay(3), equalTo("21"));
    }

    @Test
    public void countAndSaySequenceForInt4() {
        assertThat(CountAndSay.countAndSay(4), equalTo("1211"));
    }

    @Test
    public void countAndSaySequenceForInt5() {
        assertThat(CountAndSay.countAndSay(5), equalTo("111221"));
    }

    @Test
    public void countAndSaySequenceForInt6() {
        assertThat(CountAndSay.countAndSay(6), equalTo("312211"));
    }

    @Test
    public void countAndSaySequenceForInt7() {
        assertThat(CountAndSay.countAndSay(7), equalTo("13112221"));
    }

    @Test
    public void countAndSaySequenceForInt8() {
        assertThat(CountAndSay.countAndSay(8), equalTo("1113213211"));
    }

}
