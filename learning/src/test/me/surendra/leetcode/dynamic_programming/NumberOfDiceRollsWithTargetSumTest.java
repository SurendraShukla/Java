package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class NumberOfDiceRollsWithTargetSumTest {

    private int callMethod(final int n, final int k, final int target) {
        return new NumberOfDiceRollsWithTargetSum().numRollsToTarget(n, k, target);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(1, 6, 3),
            equalTo(1)
        );

        assertThat(
            callMethod(2, 6, 7),
            equalTo(6)
        );
        assertThat(
            callMethod(30, 30, 1000),
            equalTo(0)
        );
    }


}
