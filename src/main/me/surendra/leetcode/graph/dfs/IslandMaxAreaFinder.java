package me.surendra.leetcode.graph.dfs;

/**
 * @see <a href="https://leetcode.com/problems/max-area-of-island/">Max Area of Island</a>
 */
public class IslandMaxAreaFinder {

    /*
        Time Complexity - O(m * n) m is rows, n is cols
        Space Complexity - O(m * n) m is rows, n is cols
     */
    int rowMax;
    int colMax;
    int[][] matrix;
    public int maxAreaOfIslandUsingDfs(final int[][] grid) {
        rowMax = grid.length;
        colMax = grid[0].length;
        this.matrix = grid;

        int maxArea = 0;
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(row, col, 1));
                }
            }
        }
        return maxArea;
    }

    private int dfs(final int row, final int col, final int count) {
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax || matrix[row][col] == 0) {
            return 0;
        }
        matrix[row][col] = 0;
        int result = 1;
        result += dfs(row + 1, col, count + 1);
        result += dfs(row, col + 1, count + 1);
        result += dfs(row - 1, col, count + 1);
        result += dfs(row, col - 1, count + 1);

        return result;
    }


}
