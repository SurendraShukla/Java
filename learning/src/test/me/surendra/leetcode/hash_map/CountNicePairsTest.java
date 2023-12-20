package me.surendra.leetcode.hash_map;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CountNicePairsTest {

    private final CountNicePairs countNicePairs = new CountNicePairs();

    private int callMethod(final int... nums) {
        return countNicePairs.countNicePairs(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(42, 11, 1, 97), equalTo(2));
        assertThat(callMethod(13, 10, 35, 24, 76), equalTo(4));
        assertThat(callMethod(11, 11, 11, 11, 11), equalTo(10));
        assertThat(callMethod(12, 21, 21, 21, 21), equalTo(6));
        assertThat(callMethod(12, 12, 21, 21, 21), equalTo(4));
        assertThat(callMethod(12, 12, 21, 21, 21, 21), equalTo(7));
    }

}
