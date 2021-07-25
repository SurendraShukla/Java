package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CoinChangerTest {

    private int callMethod(final int[] input, final int amount) {
//        return new CoinChanger().coinChangeUsingRecursion(input, amount);
        return new CoinChanger().coinChangeUsingRecursionWithMemoization(input, amount);
//        return new CoinChanger().coinChangeUsingDynamicProgramming(input, amount);
    }

    @Test
    public void shouldMinus1IfReturnNumberOfCoins() {
        assertThat(callMethod(new int[]{2}, 3), equalTo(-1));
    }

    @Test
    public void shouldReturnNumberOfCoins() {
//        assertThat(callMethod(new int[]{1}, 0), equalTo(0));
//        assertThat(callMethod(new int[]{1}, 1), equalTo(1));
        assertThat(callMethod(new int[]{1}, 2), equalTo(2));
    }

    @Test
    public void testWithDifferentDenominations() {
        assertThat(callMethod(new int[]{1,2,5}, 1), equalTo(1));
        assertThat(callMethod(new int[]{1,2,5}, 2), equalTo(1));
        assertThat(callMethod(new int[]{1,2,5}, 5), equalTo(1));
        assertThat(callMethod(new int[]{1,2,5}, 3), equalTo(2));
        assertThat(callMethod(new int[]{1,2,5}, 6), equalTo(2));
        assertThat(callMethod(new int[]{1,2,5}, 7), equalTo(2));
        assertThat(callMethod(new int[]{1,2,5}, 8), equalTo(3));
        assertThat(callMethod(new int[]{1,2,5}, 9), equalTo(3));
        assertThat(callMethod(new int[]{1,2,5}, 11), equalTo(3));
    }

    @Test
    public void timeLimitExceedTest() {
        assertThat(callMethod(new int[]{186,419,83,408}, 6249), equalTo(20));
    }

}
