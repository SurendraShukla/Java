package me.surendra.leetcode.dynamic_programming.one_d;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PaintHouseTest {

    private int callMethod(final int[][] costs) {
        return new PaintHouse().minCost(costs);
    }

    @Test
    public void test1() {
        final int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};

        assertThat(callMethod(costs), equalTo(10));
    }

    @Test
    public void test2() {
        final int[][] costs = {{7, 6, 2}};

        assertThat(callMethod(costs), equalTo(2));
    }

}
