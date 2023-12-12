package me.surendra.leetcode.array.easy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumProductOfTwoElementsTest {

    private final MaximumProductOfTwoElements maximumProductOfTwoElements = new MaximumProductOfTwoElements();

    private int callMethod(final int[] nums) {
        return maximumProductOfTwoElements.maxProduct(nums);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{3, 4, 5, 2}),
            equalTo(12)
        );

        assertThat(
            callMethod(new int[]{1, 5, 4, 5}),
            equalTo(16)
        );

        assertThat(
            callMethod(new int[]{3, 7}),
            equalTo(12)
        );
    }

}
