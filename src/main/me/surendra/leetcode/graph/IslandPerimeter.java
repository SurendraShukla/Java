package me.surendra.leetcode.graph;

/**
 * @see <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 */
public class IslandPerimeter {
    
    /*
        Time complexity: O(m * n)
        Space complexity: O(1)
     */
    int rowMax;
    int colMax;
    int[][] matrix;
    public int getLandPerimeterByCheckingAtAllFourSides(final int[][] grid) {
        rowMax = grid.length;
        colMax = grid[0].length;

        final int[] rows = {0, 1, 0, -1};
        final int[] cols = {1, 0, -1, 0};

        int perimeter = 0;
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }
                perimeter += 4;

                for (int dIdx = 0; dIdx < rows.length; dIdx++) {
                    final int nextRow = rows[dIdx] + row;
                    final int nextCol = cols[dIdx] + col;
                    if (nextRow < 0 || nextRow >= rowMax ||
                        nextCol < 0 || nextCol >= colMax ||
                        grid[nextRow][nextCol] == 0
                    ) {
                        continue;
                    }
                    perimeter -= 1;
                }
            }
        }

        return perimeter;
    }

    /*
        Time complexity: O(m * n)
        Space complexity: O(1)
     */
    public int getLandPerimeterByCheckingUpAndLeftSide(final int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    // Left
                    if ((col > 0) && (grid[row][col - 1] == 1)) {
                        perimeter -= 2;
                    }
                    // Top
                    if ((row > 0) && (grid[row - 1][col] == 1)) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    /*
        Time complexity: O(m * n)
        Space complexity: O(1)
     */
    public int islandPerimeterBfs(final int[][] grid) {
        rowMax = grid.length;
        colMax = grid[0].length;
        matrix = grid;

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (matrix[row][col] == 1) {
                    return islandPerimeterUsingBfs(row, col);
                }
            }
        }
        return 0;
    }

    private int islandPerimeterUsingBfs(final int row, final int col) {
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax || matrix[row][col] == 0) {
            return 1;
        }
        if (matrix[row][col] == 2) {
            return 0;
        }
        matrix[row][col] = 2;

        int perimeter = 0;
        perimeter += islandPerimeterUsingBfs(row, col - 1);
        perimeter += islandPerimeterUsingBfs(row, col + 1);
        perimeter += islandPerimeterUsingBfs(row - 1, col);
        perimeter += islandPerimeterUsingBfs(row + 1, col);
        return perimeter;
    }

}
