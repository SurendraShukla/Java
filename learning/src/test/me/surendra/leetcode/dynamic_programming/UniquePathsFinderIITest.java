package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class UniquePathsFinderIITest {

    private final UniquePathsFinderII unit = new UniquePathsFinderII();

    private void callAndAssert(final int[][] obstacleGrid, final int expected) {
        final long actual = unit.uniquePathsWithObstacles(obstacleGrid);
//        final long actual = unit.uniquePathsWithObstaclesUsingExtraSpace(obstacleGrid);

        assertThat(actual, equalTo(Integer.valueOf(expected).longValue()));
    }

    @Test
    public void obstacleInMiddle() {
        callAndAssert(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        }, 2);
    }

    @Test
    public void obstacleInRight() {
        callAndAssert(new int[][]{
            {0, 1},
            {0, 0}
        }, 1);
    }

    @Test
    public void obstacleAt2RowAnd2Column() {
        callAndAssert(new int[][]{
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        }, 8);
    }

    @Test
    public void obstacleOnStartCellAnd1Row() {
        callAndAssert(new int[][]{
            {1, 0},
        }, 0);
    }

    @Test
    public void obstacleOnStartCellAnd2Row() {
        callAndAssert(new int[][]{
            {1, 0},
            {0, 0}
        }, 0);
    }

    @Test
    public void obstaclesOnWholeRow() {
        callAndAssert(new int[][]{
            {0, 0},
            {1, 1},
            {0, 0}
        }, 0);
    }

    @Test
    public void obstacleOnImmediateRightAndBelow() {
        callAndAssert(new int[][]{
            {0, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        }, 0);
    }

    @Test
    public void obstacleOnImmediateRightAndBelow2() {
        callAndAssert(new int[][]{
            {0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        }, 0);
    }

}
