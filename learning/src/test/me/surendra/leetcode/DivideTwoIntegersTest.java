package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DivideTwoIntegersTest {

    private int callMethod(final int dividend, final int divisor) {
        return new DivideTwoIntegers().divide(dividend, divisor);
    }

    @Test
    public void bothPositive() {
        System.out.println(Math.abs(30 - 20));
//
//        assertThat(callMethod(0, 1), equalTo(0));
//        assertThat(callMethod(1, 1), equalTo(1));
//
//        assertThat(callMethod(1, 3), equalTo(0));
//        assertThat(callMethod(2, 3), equalTo(0));
//        assertThat(callMethod(3, 3), equalTo(1));
//        assertThat(callMethod(10, 3), equalTo(3));
    }

    @Test
    public void bothNegative() {
        assertThat(callMethod(-7, -3), equalTo(2));
    }

    @Test
    public void mixed() {
        assertThat(callMethod(-7, 3), equalTo(-2));
        assertThat(callMethod(7, -3), equalTo(-2));
    }

    @Test
    public void intMinRange() {
        assertThat(callMethod(-2147483648, -1), equalTo(2147483647));
        assertThat(callMethod(-2147483648, 1), equalTo(-2147483648));

        assertThat(callMethod(-2147483648, 2), equalTo(-1073741824));
        assertThat(callMethod(-2147483648, -2), equalTo(2147483647));
    }

    @Test
    public void intMaxRange() {
        assertThat(callMethod(2147483647, -1), equalTo(-2147483647));
        assertThat(callMethod(2147483647, 1), equalTo(2147483647));
    }

}
