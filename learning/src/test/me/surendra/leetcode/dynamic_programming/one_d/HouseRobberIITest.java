package me.surendra.leetcode.dynamic_programming.one_d;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HouseRobberIITest {

    private int callMethod(final int[] houses) {
        return new HouseRobberII().rob(houses);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{2, 3, 2}),
            equalTo(3)
        );

        assertThat(
            callMethod(new int[]{1, 2, 3, 1}),
            equalTo(4)
        );

        assertThat(
            callMethod(new int[]{1, 2, 3}),
            equalTo(3)
        );

        assertThat(
            callMethod(new int[]{1}),
            equalTo(1)
        );
    }

}
