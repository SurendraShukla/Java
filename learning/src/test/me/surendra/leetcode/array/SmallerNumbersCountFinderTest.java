package me.surendra.leetcode.array;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SmallerNumbersCountFinderTest {

    private int[] callMethod(final int[] nums) {
        return new SmallerNumbersCountFinder().smallerNumbersThanCurrent(nums);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{8, 1, 2, 2, 3}),
            equalTo(new int[]{4, 0, 1, 1, 3})
        );

        assertThat(
            callMethod(new int[]{6, 5, 4, 8}),
            equalTo(new int[]{2, 1, 0, 3})
        );

        assertThat(
            callMethod(new int[]{7, 7, 7, 7}),
            equalTo(new int[]{0, 0, 0, 0})
        );

    }

}
