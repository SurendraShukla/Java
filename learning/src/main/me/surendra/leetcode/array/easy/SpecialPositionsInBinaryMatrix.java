package me.surendra.leetcode.array.easy;


/**
 * @see <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/">Special Positions in a Binary Matrix</a>
 */
public class SpecialPositionsInBinaryMatrix {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)

        Precompute the Number of Ones in each Row and Column
     */
    public int numSpecial(final int[][] mat) {
        final int rowMax = mat.length;
        final int colMax = mat[0].length;
        final int[] rowCountArr = new int[rowMax];
        final int[] colCountArr = new int[colMax];

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (mat[row][col] == 1) {
                    rowCountArr[row]++;
                    colCountArr[col]++;
                }
            }
        }

        int result = 0;
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if ( mat[row][col] == 1 &&
                    rowCountArr[row] == 1 &&
                    colCountArr[col] == 1
                ) {
                    result++;
                }
            }
        }

        return result;
    }

}
