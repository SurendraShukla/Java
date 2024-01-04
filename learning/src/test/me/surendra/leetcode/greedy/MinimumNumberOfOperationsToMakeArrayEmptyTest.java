package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MinimumNumberOfOperationsToMakeArrayEmptyTest {

    private final MinimumNumberOfOperationsToMakeArrayEmpty unit = new MinimumNumberOfOperationsToMakeArrayEmpty();

    private int callMethod(final int[] nums) {
        return unit.minOperations(nums);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}),
            equalTo(4)
        );

        assertThat(
            callMethod(new int[]{2, 1, 2, 2, 3, 3}),
            equalTo(-1)
        );
    }

}
