package me.surendra.leetcode.graph.dfs;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class IslandMaxAreaFinderTest {

    private final IslandMaxAreaFinder islandMaxAreaFinder = new IslandMaxAreaFinder();

    private int callMethod(final int[][] grid) {
        return islandMaxAreaFinder.maxAreaOfIslandUsingDfs(grid);
    }

    @Test
    public void multipleIsLands() {
       final int[][] grid = {
           {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
           {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
           {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
           {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
           {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
           {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
           {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
       };

        assertThat(callMethod(grid), equalTo(6));
    }

    @Test
    public void noIsLand() {
        final int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};

        assertThat(callMethod(grid), equalTo(0));
    }

    @Test
    public void onlyOne() {
        final int[][] grid = {{1}};

        assertThat(callMethod(grid), equalTo(1));
    }
    @Test
    public void firstValueOfGridIsIsLand() {
        final int[][] grid = {{1}, {0}};

        assertThat(callMethod(grid), equalTo(1));
    }


    @Test
    public void oneIsLandInHorizontal() {
        final int[][] grid = {{1, 1}};

        assertThat(callMethod(grid), equalTo(2));
    }

    @Test
    public void oneIsLandInVertical() {
        final int[][] grid = {{1}, {1}};

        assertThat(callMethod(grid), equalTo(2));
    }

    @Test
    public void isLandInReverseLShape() {
        final int[][] grid = {
            {0, 1},
            {0, 1},
            {1, 1},
        };

        assertThat(callMethod(grid), equalTo(4));
    }

    @Test
    public void is() {
        final int[][] grid = {
            {1, 1},
            {1, 0}
        };

        assertThat(callMethod(grid), equalTo(3));
    }

}
