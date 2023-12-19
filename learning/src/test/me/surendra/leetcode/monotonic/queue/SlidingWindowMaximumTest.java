package me.surendra.leetcode.monotonic.queue;


import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SlidingWindowMaximumTest {

    private final SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    private int[] callMethod(final int[] nums, final int k) {
        return slidingWindowMaximum.maxSlidingWindowUsingMonotonicQueue(nums, k);
    }

    @Test
    public void shouldReturnAllElementsIfWidowSizeIs1() {
        assertThat(
            callMethod(new int[]{1}, 1),
            equalTo(new int[]{1})
        );

        assertThat(
            callMethod(new int[]{1, -1}, 1),
            equalTo(new int[]{1, -1})
        );

        assertThat(
            callMethod(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3),
            equalTo(new int[]{3, 3, 5, 5, 6, 7})
        );

        assertThat(
            callMethod(new int[]{3, 3, 3, 1}, 2),
            equalTo(new int[]{3, 3, 3})
        );

        assertThat(
            callMethod(new int[]{1, 3, 1, 2, 0, 5}, 3),
            equalTo(new int[]{3, 3, 2, 5})
        );

    }

}
