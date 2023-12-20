package me.surendra.leetcode.hash_map;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class GoodPairsNumberCounterTest {

    private int callMethod(final int[] nums) {
        return new GoodPairsNumberCounter().numIdenticalPairs(nums);
//        return new GoodPairsNumberCounter().numIdenticalPairsUsingPair(nums);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{1, 2, 3}), equalTo(0));

        assertThat(callMethod(new int[]{1}), equalTo(0));
        assertThat(callMethod(new int[]{1, 1}), equalTo(1));
        assertThat(callMethod(new int[]{1, 1, 1}), equalTo(3));
        assertThat(callMethod(new int[]{1, 1, 1, 1}), equalTo(6));
        assertThat(callMethod(new int[]{1, 1, 1, 1, 1}), equalTo(10));
        assertThat(callMethod(new int[]{1, 1, 1, 1, 1, 1}), equalTo(15));
        assertThat(callMethod(new int[]{1, 1, 1, 1, 1, 1, 1}), equalTo(21));

        assertThat(callMethod(new int[]{1, 2, 3, 1, 1, 3}), equalTo(4));
    }

}

