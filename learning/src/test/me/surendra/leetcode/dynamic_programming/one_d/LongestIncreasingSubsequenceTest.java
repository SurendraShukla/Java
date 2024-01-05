package me.surendra.leetcode.dynamic_programming.one_d;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LongestIncreasingSubsequenceTest {

    private final LongestIncreasingSubsequence unit = new LongestIncreasingSubsequence();

    @Test
    public void test() {
        assertThat(
            unit.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}),
            equalTo(4)
        );

        assertThat(
            unit.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}),
            equalTo(4)
        );

        assertThat(
            unit.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}),
            equalTo(1)
        );

        assertThat(
            unit.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}),
            equalTo(3)
        );
    }
}
