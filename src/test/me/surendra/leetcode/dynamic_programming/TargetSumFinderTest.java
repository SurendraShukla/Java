package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TargetSumFinderTest {

    private final TargetSumFinder targetSumFinder = new TargetSumFinder();

    private int callMethod(final int[] nums, final int target) {
        return targetSumFinder.findTargetSumWaysUsingRecursionWithoutSpace(nums, target);
//        return targetSumFinder.findTargetSumWaysUsingRecursionWithSpace(nums, target);
//        return targetSumFinder.findTargetSumWaysSelfThought(nums, target);
    }

    @Test
    public void test1() {
        final int[] nums = {1};

        assertThat(callMethod(nums, 1), equalTo(1));
    }

    @Test
    public void test2() {
        final int[] nums = {1, 1, 1, 1, 1};

        assertThat(callMethod(nums, 3), equalTo(5));
    }

    @Test
    public void timeLimitExceeded1() {
        final int[] nums = {25, 33, 27, 23, 46, 16, 10, 27, 33, 2, 12, 2, 29, 44, 49, 40, 32, 46, 7, 50};

        assertThat(callMethod(nums, 4), equalTo(0));
    }

    @Test
    public void timeLimitExceeded2() {
        final int[] nums = {25, 18, 47, 13, 45, 29, 15, 45, 33, 19, 39, 15, 39, 45, 17, 21, 29, 43, 50, 10};

        assertThat(callMethod(nums, 25), equalTo(5392));
    }

}
