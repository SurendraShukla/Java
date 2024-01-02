package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MaximumSubArrayFinderTest {

    private final MaximumSubArrayFinder maximumSubArrayFinder = new MaximumSubArrayFinder();

    private int callMethod(final int[] nums) {
        return maximumSubArrayFinder.maxSubArrayUsingJosephKadaneAlgo(nums);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{1}), equalTo(1));
        assertThat(callMethod(new int[]{-2, -3}), equalTo(-2));
        assertThat(callMethod(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), equalTo(6));
        assertThat(callMethod(new int[]{5, 4, -1, 7, 8}), equalTo(23));
    }

}
