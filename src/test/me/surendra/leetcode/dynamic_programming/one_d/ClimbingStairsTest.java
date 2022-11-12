package me.surendra.leetcode.dynamic_programming.one_d;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClimbingStairsTest {

    private final ClimbingStairs climbingStairs = new ClimbingStairs();

    private int callMethod(final int n) {
        return climbingStairs.climbStairsUsingFibonacci(n);
    }

    @Test
    public void test() {
        assertThat(callMethod(2), equalTo(2));
        assertThat(callMethod(3), equalTo(3));
        assertThat(callMethod(45), equalTo(1836311903
        ));
    }

}
