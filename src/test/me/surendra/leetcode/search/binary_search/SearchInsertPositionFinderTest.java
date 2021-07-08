package me.surendra.leetcode.search.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SearchInsertPositionFinderTest {

    private int callMethod(final int[] nums, final int target) {
        return new SearchInsertPositionFinder().searchInsert(nums, target);
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 6};
        assertThat(callMethod(nums, 5), equalTo(2));
        assertThat(callMethod(nums, 2), equalTo(1));
        assertThat(callMethod(nums, 7), equalTo(4));
        assertThat(callMethod(nums, 0), equalTo(0));
    }

    @Test
    public void test2() {
        int[] nums = {1};
        assertThat(callMethod(nums, 0), equalTo(0));
    }

}
