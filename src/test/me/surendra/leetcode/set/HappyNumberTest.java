package me.surendra.leetcode.set;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class HappyNumberTest {

    private boolean callMethod(final int n) {
        return new HappyNumber().isHappy(n);
    }

    @Test
    public void happyNumber() {
        assertThat(callMethod(1), equalTo(true));
        assertThat(callMethod(7), equalTo(true));
        assertThat(callMethod(10), equalTo(true));
        assertThat(callMethod(19), equalTo(true));
    }

    @Test
    public void nonHappyNumber() {
        assertThat(callMethod(2), equalTo(false));
        assertThat(callMethod(3), equalTo(false));
        assertThat(callMethod(4), equalTo(false));
        assertThat(callMethod(5), equalTo(false));
        assertThat(callMethod(6), equalTo(false));
        assertThat(callMethod(8), equalTo(false));
        assertThat(callMethod(9), equalTo(false));
        assertThat(callMethod(2147483646), equalTo(false));
    }
}
