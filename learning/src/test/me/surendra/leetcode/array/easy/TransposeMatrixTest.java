package me.surendra.leetcode.array.easy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TransposeMatrixTest {

    private final TransposeMatrix transposeMatrix = new TransposeMatrix();

    @Test
    public void test() {
        assertThat(
            transposeMatrix.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
            equalTo(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}})
        );

        assertThat(
            transposeMatrix.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}),
            equalTo(new int[][]{{1, 4}, {2, 5}, {3, 6}})
        );
    }

}
