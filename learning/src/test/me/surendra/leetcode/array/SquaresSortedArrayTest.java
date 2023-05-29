package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SquaresSortedArrayTest {

    private int[] callMethod(final int[] nums) {
        return new SquaresSortedArray().sortedSquares(nums);
    }

    @Test
    public void test1() {
        final int[] nums = {-4, -1, 0, 3, 10};
        final int[] expected = {0,1,9,16,100};

        final int[] actual = callMethod(nums);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[] nums = {-7,-3,2,3,11};
        final int[] expected = {4,9,9,49,121};

        final int[] actual = callMethod(nums);
        assertThat(actual, equalTo(expected));
    }
}
