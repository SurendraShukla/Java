package me.surendra.leetcode.binary_search;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SearchIn2DMatrixTest {

    private final SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();

    private boolean callMethod(final int[][] matrix, final int target) {
        return searchIn2DMatrix.searchMatrix(matrix, target);
    }

    @Test
    public void test() {
        final int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        assertThat(callMethod(matrix, 3), equalTo(true));
        assertThat(callMethod(matrix, 13), equalTo(false));
        assertThat(callMethod(new int[][]{{1, 1}}, 2), equalTo(false));
        assertThat(callMethod(new int[][]{{1}, {3}}, 3), equalTo(true));
    }

}
