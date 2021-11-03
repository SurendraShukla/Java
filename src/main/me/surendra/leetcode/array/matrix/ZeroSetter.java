package me.surendra.leetcode.array.matrix;


/**
 * @see <a href="https://leetcode.com/problems/set-matrix-zeroes/">Set Matrix Zeroes</a>
 */
public class ZeroSetter {

    /*
        Time Complexity - O(n * m) n is rows, m is columns
        Space Complexity- O(n + m) n is rows, m is columns
     */
    int rows;
    int cols;
    int[] rowsToBeZeroed;
    int[] colsToBeZeroed;
    public void setZeroes(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        rowsToBeZeroed = new int[rows];
        colsToBeZeroed = new int[cols];

        // Essentially, we mark the rows and columns that are to be made zero
        populateRowsAndColsToBeZeroed(matrix);
        // Iterate over the array once again and using the rows and cols sets, update the elements.
        setZeroesInMatrix(matrix);
    }

    private void populateRowsAndColsToBeZeroed(final int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col =0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    rowsToBeZeroed[row] = 1;
                    colsToBeZeroed[col] = 1;
                }
            }
        }
    }

    private void setZeroesInMatrix(final int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col =0; col < cols; col++) {
                if (rowsToBeZeroed[row] == 1 || colsToBeZeroed[col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }


    /*
        Time Complexity - O(n*m) n is rows, m is columns
        Space Complexity - O(n + m) n is rows, m is columns
     */
    public void setZeroesUsingConstantSpace(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
