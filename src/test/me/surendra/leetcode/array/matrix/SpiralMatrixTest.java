package me.surendra.leetcode.array.matrix;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SpiralMatrixTest {

    private List<Integer> callMethod(final int[][] matrix) {
        return new SpiralMatrix().spiralOrder(matrix);
    }

    @Test
    public void spiralMatrixWith1x1() {
        final int[][] matrix = {
            {1}
        };
        final ArrayList<Integer> expectedList = newArrayList(1);

        assertThat(callMethod(matrix), equalTo(expectedList));
    }

    @Test
    public void spiralMatrixWith1x2() {
        final int[][] matrix = {
            {1, 2}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2);

        assertThat(callMethod(matrix), equalTo(expectedList));
    }

    @Test
    public void spiralMatrixWith2x1() {
        final int[][] matrix = {
            {1},
            {2}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2);

        assertThat(callMethod(matrix), equalTo(expectedList));
    }

    @Test
    public void spiralMatrixWith3x3() {
        final int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2, 3, 6, 9, 8, 7, 4, 5);

        assertThat(callMethod(matrix), equalTo(expectedList));
    }

    @Test
    public void spiralMatrixWith3x4() {
        final int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);

        assertThat(callMethod(matrix), equalTo(expectedList));
    }

}
