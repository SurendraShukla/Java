package me.surendra.leetcode.dequeue;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumCoinsGetterTest {

    private final MaximumCoinsGetter maximumCoinsGetter = new MaximumCoinsGetter();

    private int callMethod(final int[] piles) {
        return maximumCoinsGetter.maxCoins(piles);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{2, 4, 1, 2, 7, 8}), equalTo(9));
        assertThat(callMethod(new int[]{2, 4, 5}), equalTo(4));
        assertThat(callMethod(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}), equalTo(18));
    }

}
