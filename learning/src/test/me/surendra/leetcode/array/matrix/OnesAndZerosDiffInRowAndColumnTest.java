package me.surendra.leetcode.array.matrix;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class OnesAndZerosDiffInRowAndColumnTest {

    private final OnesAndZerosDiffInRowAndColumn onesAndZerosDiffInRowAndColumn = new OnesAndZerosDiffInRowAndColumn();

    private int[][] callMethod(final int[][] grid) {
        return onesAndZerosDiffInRowAndColumn.onesMinusZeros(grid);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}}),
            equalTo(new int[][]{{0, 0, 4}, {0, 0, 4}, {-2, -2, 2}})
        );

        assertThat(
            callMethod(new int[][]{{1, 1, 1}, {1, 1, 1}}),
            equalTo(new int[][]{{5, 5, 5}, {5, 5, 5}})
        );
    }

}
