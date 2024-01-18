package me.surendra.leetcode.dynamic_programming;


/**
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/">Unique Paths II</a>
 */
public class UniquePathsFinderII {

    /*
        Time Complexity - O(n * m)
        Space Complexity - O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int col = 1; col < colLen; col++) {
            obstacleGrid[0][col] = (obstacleGrid[0][col] == 0 && obstacleGrid[0][col-1] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int row = 1; row < rowLen; row++) {
            obstacleGrid[row][0] = (obstacleGrid[row][0] == 0 && obstacleGrid[row-1][0] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for(int row=1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                }else {
                    obstacleGrid[row][col] = obstacleGrid[row][col-1] + obstacleGrid[row-1][col];
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[rowLen-1][colLen-1];
    }

    /*
        Time Complexity - O(n*m)
        Space Complexity - O(n)
     */
    public long uniquePathsWithObstaclesUsingExtraSpace(int[][] obstacleGrid) {
        // If obstacle at first place only then Robot can not move
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int maxArrLen = rowLen * colLen;
        int[] arr = new int[maxArrLen];
        arr[0] = 1;

        for(int row=0; row < rowLen; row++) {
            for(int col=0; col < colLen; col++) {
                int idx = getIndex(row, col, colLen);
                // If obstacle at this position then mark it obstacle (0)
                if (obstacleGrid[row][col] == 1) {
                    arr[idx] = 0;
                    continue;
                }
                // First row should be flipped values for easier calculation
                if (row == 0) {
                    // From 2nd column check values of previous column
                    if (col > 0) {
                        int previousCol = getIndex(row, col-1, colLen);
                        arr[idx] = arr[previousCol];
                    }
                    continue;
                }
                // Get Top Value
                int aboveValue = getIndex(row-1, col, colLen);
                int rowVal = arr[aboveValue];
                // Get Left Value
                int leftValue = 0;
                if (col-1 >= 0) {
                    int previousCol = getIndex(row, col-1, colLen);
                    leftValue = arr[previousCol];
                }
                arr[idx] = rowVal + leftValue;
            }
        }
        return arr[maxArrLen-1];
    }

    private int getIndex(int rowIdx, int colIdx, int colMax) {
        return (rowIdx * colMax) + colIdx;
    }

}
