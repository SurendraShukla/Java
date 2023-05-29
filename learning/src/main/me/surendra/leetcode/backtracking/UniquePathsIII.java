package me.surendra.leetcode.backtracking;


/**
 * @see <a href="https://leetcode.com/problems/unique-paths-iii/">Unique Paths III</a>
 */
public class UniquePathsIII {

    /*
        Time complexity: O(3 ^ n) - 3 branches (directions). Although technically we have 4 directions to explore at each step, we have at most 3 directions to try at any moment except the first step.
        Space complexity: O(n)
     */
    int rowMax;
    int colMax;
    int[][] matrix;

    int uniquePath = 0;
    int cellsNeededToBeVisited = 0;

    public int uniquePathsIII(final int[][] grid) {
        int startRow = 0;
        int startCol = 0;

        matrix = grid;
        rowMax = grid.length;
        colMax = grid[0].length;

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (grid[row][col] != -1) {
                    cellsNeededToBeVisited++;
                }
                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        dfs(startRow, startCol, 1);
        return uniquePath;
    }

    private void dfs(final int row, final int col, final int visitedCount) {
        if (row < 0 || row >= rowMax ||
            col < 0 || col >= colMax || matrix[row][col] == -1
        ) {
            return;
        }
        if (matrix[row][col] == 2) {
            if (visitedCount == cellsNeededToBeVisited) {
                uniquePath++;
            }
            return;
        }
        final int preVal = matrix[row][col];
        matrix[row][col] = -1;

        dfs(row + 1, col, visitedCount + 1);
        dfs(row, col + 1, visitedCount + 1);
        dfs(row - 1, col, visitedCount + 1);
        dfs(row, col - 1, visitedCount + 1);

        matrix[row][col] = preVal;
    }

}
