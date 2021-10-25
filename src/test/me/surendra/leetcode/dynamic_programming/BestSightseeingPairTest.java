package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BestSightseeingPairTest {

    private int callMethod(final int[] values) {
        return new BestSightseeingPair().maxScoreSightSeeingPair(values);
//        return new BestSightseeingPair().maxScoreSightSeeingPairUsing2Iteration(values);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{8,1,5,2,6}), equalTo(11));
        assertThat(callMethod(new int[]{1,2}), equalTo(2));
    }

    @Test
    public void test2() {
        assertThat(callMethod(new int[]{2,2,2}), equalTo(3));
    }
}
