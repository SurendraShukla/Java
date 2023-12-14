package me.surendra.leetcode.array.matrix;


/**
 * @see <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/">Difference Between Ones and Zeros in Row and Column</a>
 */
public class OnesAndZerosDiffInRowAndColumn {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)

        Precompute the Number of Ones in each Row and Column
     */
    public int[][] onesMinusZeros(final int[][] grid) {
        final int rowMax = grid.length;
        final int colMax = grid[0].length;
        final int[] rowCount = new int[rowMax];
        final int[] colCount = new int[colMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (grid[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        final int[][] result = new int[rowMax][colMax];
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                result[row][col] = rowCount[row] + colCount[col]
                    - (rowMax - rowCount[row])
                    - (colMax - colCount[col]);
            }
        }

        return result;
    }

}
