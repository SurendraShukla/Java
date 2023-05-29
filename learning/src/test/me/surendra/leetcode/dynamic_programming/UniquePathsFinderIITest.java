package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class UniquePathsFinderIITest {

    private void callAndAssert(final int[][] obstacleGrid, final int expected) {
        final long actual = new UniquePathsFinderII().uniquePathsWithObstacles(obstacleGrid);
//        final long actual = new UniquePathsFinderII().uniquePathsWithObstaclesUsingExtraSpace(obstacleGrid);

        assertThat(actual, equalTo(Integer.valueOf(expected).longValue()));
    }

    @Test
    public void obstacleInMiddle() {
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        callAndAssert(obstacleGrid, 2);
    }

    @Test
    public void obstacleInRight() {
        int[][] obstacleGrid = {
            {0, 1},
            {0, 0}
        };

        callAndAssert(obstacleGrid, 1);
    }

    @Test
    public void obstacleAt2RowAnd2Column() {
        int[][] obstacleGrid = {
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        callAndAssert(obstacleGrid, 8);
    }

    @Test
    public void obstacleOnStartCell() {
        int[][] obstacleGrid = {
            {1, 0},
            {0, 0}
        };

        callAndAssert(obstacleGrid, 0);
    }

    @Test
    public void obstaclesOnWholeRow() {
        int[][] obstacleGrid = {
            {0, 0},
            {1, 1},
            {0, 0}
        };

        callAndAssert(obstacleGrid, 0);
    }

    @Test
    public void obstacleOnImmediateRightAndBelow() {
        int[][] obstacleGrid = {
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        };

        callAndAssert(obstacleGrid, 0);
    }

    @Test
    public void obstacleOnImmediateRightAndBelow2() {
        int[][] obstacleGrid = {
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        callAndAssert(obstacleGrid, 0);
    }

    @Test
    public void inputMinLimit() {
//        assertThat(callMethod(1, 1), equalTo(1L));
    }

    @Test
    public void inputMaxLimit() {
//        assertThat(callMethod(100, 100), equalTo(4631081169483718960L));
    }


}
