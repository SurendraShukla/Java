package me.surendra.leetcode.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class FindFirstAndLastPositionFinderTest {

    private final FindFirstAndLastPositionFinder unit = new FindFirstAndLastPositionFinder();


    private int[] callMethod(final int[] nums, final int target) {
        return unit.searchRange(nums, target);
    }

    @Test
    public void test1() {
        final int[] nums = {5, 7, 7, 8, 8, 10};
        assertThat(callMethod(nums, 5), equalTo(new int[] {0, 0}));
        assertThat(callMethod(nums, 8), equalTo(new int[] {3, 4}));
        assertThat(callMethod(nums, 6), equalTo(new int[] {-1, -1}));
        assertThat(callMethod(nums, 10), equalTo(new int[] {5, 5}));
    }

    @Test
    public void test2() {
        assertThat(callMethod(new int[]{}, 0), equalTo(new int[] {-1, -1}));
        assertThat(callMethod(new int[]{2, 2}, 2), equalTo(new int[] {0, 1}));
    }
}
