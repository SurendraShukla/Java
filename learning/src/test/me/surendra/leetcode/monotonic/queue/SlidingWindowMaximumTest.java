package me.surendra.leetcode.monotonic.queue;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SlidingWindowMaximumTest {

    private final SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    private int[] callMethod(final int[] nums, final int k) {
        return slidingWindowMaximum.maxSlidingWindow(nums, k);
//        return slidingWindowMaximum.maxSlidingWindowUsingMonotonicQueue(nums, k);
    }

    private void callAndAssertForWindowSize1(final int[] nums, final int k) {
        assertThat(callMethod(nums, k), equalTo(nums));
    }

    @Test
    public void shouldReturnAllElementsIfWidowSizeIs1() {
        final int k = 1;
        callAndAssertForWindowSize1(new int[]{1}, k);
        callAndAssertForWindowSize1(new int[]{1, -1}, k);
    }

    @Test
    public void test1() {
        final int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        // execute
        final int[] actual = callMethod(nums, 3);

        final int[] expected = {3, 3, 5, 5, 6, 7};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[] nums = {3, 3, 3, 1};

        // execute
        final int[] actual = callMethod(nums, 2);

        final int[] expected = {3, 3, 3};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final int[] nums = {1, 3, 1, 2, 0, 5};

        // execute
        final int[] actual = callMethod(nums, 3);

        final int[] expected = {3, 3, 2, 5};
        assertThat(actual, equalTo(expected));
    }

}
