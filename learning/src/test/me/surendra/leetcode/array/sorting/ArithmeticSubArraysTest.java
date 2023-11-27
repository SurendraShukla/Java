package me.surendra.leetcode.array.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ArithmeticSubArraysTest {

    private final ArithmeticSubArrays arithmeticSubArrays = new ArithmeticSubArrays();

    private List<Boolean> callMethod(final int[] nums, final int[] left, final int[] right) {
        return arithmeticSubArrays.checkArithmeticSubArrays(nums, left, right);
    }

    @Test
    public void test1() {
        final int[] nums = {4, 6, 5, 9, 3, 7};
        final int[] left = {0, 0, 2};
        final int[] right = {2, 3, 5};
        final List<Boolean> actual = callMethod(nums, left, right);

        final List<Boolean> expected = Arrays.asList(true, false, true);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        final int[] left = {0, 1, 6, 4, 8, 7};
        final int[] right = {4, 4, 9, 7, 9, 10};
        final List<Boolean> actual = callMethod(nums, left, right);

        final List<Boolean> expected = Arrays.asList(false, true, false, false, true, true);
        assertThat(actual, equalTo(expected));
    }
}
