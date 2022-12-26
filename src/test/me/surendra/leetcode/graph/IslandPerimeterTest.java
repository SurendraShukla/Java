package me.surendra.leetcode.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IslandPerimeterTest {

    final IslandPerimeter islandPerimeter = new IslandPerimeter();

    private int callMethod(final int[][] grid) {
        return islandPerimeter.islandPerimeterBfs(grid);
//        return islandPerimeter.getLandPerimeterByCheckingUpAndLeftSide(grid);
//        return islandPerimeter.getLandPerimeterByCheckingAtAllFourSides(grid);
    }

    @Test
    public void test1() {
        final int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        assertThat(callMethod(grid), equalTo(16));
    }

    @Test
    public void test2() {
        assertThat(callMethod(new int[][]{{1}}), equalTo(4));
        assertThat(callMethod(new int[][]{{1, 0}}), equalTo(4));
    }

}
