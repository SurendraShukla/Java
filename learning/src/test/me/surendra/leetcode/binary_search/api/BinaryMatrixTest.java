package me.surendra.leetcode.binary_search.api;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinaryMatrixTest {

    private int callMethod(final int[][] matrix) {
        final BinaryMatrix binaryMatrix = new BinaryMatrix(matrix);
        return binaryMatrix.leftMostColumnWithOne(binaryMatrix);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[][]{{0, 0}, {1, 1}}), equalTo(0));
        assertThat(callMethod(new int[][]{{0, 0}, {0, 1}}), equalTo(1));
        assertThat(callMethod(new int[][]{{0, 0}, {0, 0}}), equalTo(-1));
    }

}
