package me.surendra.leetcode.array.easy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SpecialPositionsInBinaryMatrixTest {

    private final SpecialPositionsInBinaryMatrix specialPositionsInBinaryMatrix = new SpecialPositionsInBinaryMatrix();

    private int callMethod(final int[][] matrix) {
        return specialPositionsInBinaryMatrix.numSpecial(matrix);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}),
            equalTo(1)
        );

        assertThat(
            callMethod(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}),
            equalTo(3)
        );
    }

}
