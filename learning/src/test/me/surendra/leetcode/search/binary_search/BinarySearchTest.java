package me.surendra.leetcode.search.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    private int callMethod(final int[] nums, final int target) {
        return binarySearch.search(nums, target);
    }

    @Test
    public void test1() {
        final int[] nums = {-1, 0, 3, 5, 9, 12};

        assertThat(callMethod(nums, 9), equalTo(4));
        assertThat(callMethod(nums, 2), equalTo(-1));
    }

    @Test
    public void test2() {
        final int[] nums = {1,  2, 3, 4, 5, 6, 7, 8, 9};

        assertThat(callMethod(nums, 1), equalTo(0));
        assertThat(callMethod(nums, 2), equalTo(1));
        assertThat(callMethod(nums, 3), equalTo(2));
        assertThat(callMethod(nums, 4), equalTo(3));
        assertThat(callMethod(nums, 5), equalTo(4));
        assertThat(callMethod(nums, 6), equalTo(5));
        assertThat(callMethod(nums, 7), equalTo(6));
        assertThat(callMethod(nums, 8), equalTo(7));
        assertThat(callMethod(nums, 9), equalTo(8));
    }


    @Test
    public void test3() {
        final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        assertThat(callMethod(nums, 1), equalTo(0));
        assertThat(callMethod(nums, 2), equalTo(1));
        assertThat(callMethod(nums, 3), equalTo(2));
        assertThat(callMethod(nums, 4), equalTo(3));
        assertThat(callMethod(nums, 5), equalTo(4));
        assertThat(callMethod(nums, 6), equalTo(5));
        assertThat(callMethod(nums, 7), equalTo(6));
        assertThat(callMethod(nums, 8), equalTo(7));
    }


}
