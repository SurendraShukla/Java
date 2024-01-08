package me.surendra.leetcode.binary_search.api;


import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/leftmost-column-with-at-least-a-one/">Leftmost Column with at Least a One</a>
 */
public class BinaryMatrix {

    /*
        Time Complexity - O(n long n)
        Space Complexity - O(1)
     */
    public int leftMostColumnWithOne(final BinaryMatrix binaryMatrix) {
        final List<Integer> matrixInfo = binaryMatrix.dimensions();
        final int rows = matrixInfo.get(0);
        final int cols = matrixInfo.get(1);

        int result = cols;
        for (int row = 0; row < rows; row++) {
            final int rowResult = binarySearch(row, result, binaryMatrix);
            result = Math.min(result, rowResult);
        }
        return result == cols ? -1 : result;
    }

    private int binarySearch(final int row, final int col, final BinaryMatrix binaryMatrix) {
        int left = 0;
        int right = col - 1;
        int leftMostOneIdx = col;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (binaryMatrix.get(row, mid) == 1) {
                leftMostOneIdx = Math.min(leftMostOneIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return leftMostOneIdx;
    }

    private int[][] matrix;
    BinaryMatrix(final int[][] matrix) {
        this.matrix = matrix;
    }

    public int get(final int row, final int col) {
        return matrix[row][col];
    }

    public List<Integer> dimensions() {
        return Arrays.asList(matrix.length, matrix[0].length);
    }

}
