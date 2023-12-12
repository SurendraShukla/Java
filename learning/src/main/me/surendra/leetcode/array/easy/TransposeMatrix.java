package me.surendra.leetcode.array.easy;


/**
 * @see <a href="https://leetcode.com/problems/transpose-matrix/">Transpose Matrix</a>
 */
public class TransposeMatrix {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int[][] transpose(final int[][] matrix) {

        final int rowMax = matrix.length;
        final int colMax = matrix[0].length;
        final int[][] result = new int[colMax][rowMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                result[col][row] = matrix[row][col];
            }
        }

        return result;
    }

}
