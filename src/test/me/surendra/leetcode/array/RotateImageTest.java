package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RotateImageTest {

    private void callMethod(final int[][] inputMatrix) {
        new RotateImage().rotate(inputMatrix);
    }

    @Test
    public void rotationFor1x1Matrix() {
        final int[][] inputMatrix = {{1}};
        final int[][] expectedMatrix = {{1}};

        callMethod(inputMatrix);

        assertThat(inputMatrix, equalTo(expectedMatrix));
    }

    @Test
    public void rotationFor2x2Matrix() {
        final int[][] inputMatrix = {
            {1,2},
            {3,4}
        };
        final int[][] expectedMatrix = {
            {3,1},
            {4,2}
        };

        callMethod(inputMatrix);

        assertThat(inputMatrix, equalTo(expectedMatrix));
    }

    @Test
    public void rotationFor3x3Matrix() {
        final int[][] inputMatrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        final int[][] expectedMatrix = {
            {7,4,1},
            {8,5,2},
            {9,6,3}
        };

        callMethod(inputMatrix);

        assertThat(inputMatrix, equalTo(expectedMatrix));
    }

    @Test
    public void rotationFor4x4Matrix() {
        final int[][] inputMatrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        final int[][] expectedMatrix = {
            {15,13,2,5},
            {14,3,4,1},
            {12,6,8,9},
            {16,7,10,11}
        };

        callMethod(inputMatrix);

        assertThat(inputMatrix, equalTo(expectedMatrix));
    }

}
