package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MinCostClimbingStairsCostFinderTest {

    private final MinCostClimbingStairsCostFinder minCostClimbingStairsCostFinder = new MinCostClimbingStairsCostFinder();

    private int callMethod(final int[] cost) {
        return minCostClimbingStairsCostFinder.minCostClimbingStairsUsingTabulation(cost);
//        return minCostClimbingStairsCostFinder.minCostClimbingStairsUsingConstantSpace(cost);
//        return minCostClimbingStairsCostFinder.minCostClimbingStairsUsingRecursion(cost);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{10, 15, 20}), equalTo(15));
        assertThat(callMethod(new int[]{1, 100, 1, 1, 1, 100, 1 , 1, 100, 1}), equalTo(6));
    }

}
