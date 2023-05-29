package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class NextPermutationFinderTest {

    private void callMethod(final int[] nums) {
        new NextPermutationFinder().nextPermutation(nums);
    }

    @Test
    public void allSameNumbers() {
        final int[] nums = {1,1,1};
        final int[] expected = {1,1,1};

        callMethod(nums);

        assertThat(nums, equalTo(expected));
    }

    @Test
    public void numbersInIncreasingOrder() {
        final int[] nums = {1,2,3};
        final int[] expected = {1,3,2};

        callMethod(nums);

        assertThat(nums, equalTo(expected));
    }

    @Test
    public void numbersInDecreasingOrder() {
        final int[] nums = {3,2,1};
        final int[] expected = {1,2,3};

        callMethod(nums);

        assertThat(nums, equalTo(expected));
    }

    @Test
    public void inBetweenReplacement1() {
        final int[] nums = {1,1,5};
        final int[] expected = {1,5,1};

        callMethod(nums);

        assertThat(nums, equalTo(expected));
    }

    @Test
    public void inBetweenReplacement2() {
        final int[] nums = {1,3,2};
        final int[] expected = {2,1,3};

        callMethod(nums);

        assertThat(nums, equalTo(expected));
    }

}
