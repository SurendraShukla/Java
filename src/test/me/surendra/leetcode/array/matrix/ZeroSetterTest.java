package me.surendra.leetcode.array.matrix;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ZeroSetterTest {

    private void callMethod(final int[][] matrix) {
        new ZeroSetter().setZeroes(matrix);
//        new ZeroSetter().setZeroesUsingConstantSpace(matrix);
    }

    @Test
    public void test1() {
        final int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        callMethod(matrix);

        final int[][] expected = {{1,0,1},{0,0,0},{1,0,1}};
        assertThat(matrix, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[][] matrix = {{0,0,1},{1,1,1},{1,1,1}};

        callMethod(matrix);

        final int[][] expected = {{0,0,0},{0,0,1},{0,0,1}};
        assertThat(matrix, equalTo(expected));
    }

    @Test
    public void test3() {
        final int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        callMethod(matrix);

        final int[][] expected = {{0,0,0,0},{0,4,5,0},{0,3,1,0}};
        assertThat(matrix, equalTo(expected));
    }

}
