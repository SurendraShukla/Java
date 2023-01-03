package me.surendra.leetcode.backtracking;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class UniquePathsIIITest {

    private final UniquePathsIII uniquePathsIII = new UniquePathsIII();

    private int callMethod(final int[][] grid) {
        return uniquePathsIII.uniquePathsIII(grid);
    }

    @Test
    public void test1() {
        final int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

        assertThat(callMethod(grid), equalTo(2));
    }

    @Test
    public void test2() {
        final int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};

        assertThat(callMethod(grid), equalTo(4));
    }

    @Test
    public void test3() {
        final int[][] grid = {{0, 1}, {2, 0}};

        assertThat(callMethod(grid), equalTo(0));
    }

}
