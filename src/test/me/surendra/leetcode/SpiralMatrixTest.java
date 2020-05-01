package me.surendra.leetcode;

import org.junit.Test;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SpiralMatrixTest {

    @Test
    public void sprialMatrixWith0x0() {
        final int[][] matrix = {};
        final ArrayList<Integer> expectedList = newArrayList();

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

    @Test
    public void sprialMatrixWith1x1() {
        final int[][] matrix = {
            {1}
        };
        final ArrayList<Integer> expectedList = newArrayList(1);

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

    @Test
    public void sprialMatrixWith1x2() {
        final int[][] matrix = {
            {1, 2}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2);

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

    @Test
    public void sprialMatrixWith2x1() {
        final int[][] matrix = {
            {1},
            {2}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2);

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

    @Test
    public void sprialMatrixWith3x3() {
        final int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2, 3, 6, 9, 8, 7, 4, 5);

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

    @Test
    public void sprialMatrixWith3x4() {
        final int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        };
        final ArrayList<Integer> expectedList = newArrayList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);

        assertThat(new SpiralMatrix().spiralOrder(matrix), equalTo(expectedList));
    }

}
