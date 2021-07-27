package me.surendra.leetcode.graph;

/**
 * @see <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 */
public class IslandPerimeter {
    
    /*
        Time complexity: O(m*n)
        Space complexity: O(1)
     */
    public static int getLandPerimeterByCheckingAtAllFourSides(final int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int row = 0; row<rows; row++) {
            for (int col = 0; col<cols; col++) {

                if(grid[row][col] == 1) {
                    perimeter += 4;
                    // Top
                    if ((row > 0) && (grid[row - 1][col] == 1)) {
                        perimeter -= 1;
                    }
                    // Right
                    if ((col < cols - 1) && (grid[row][col + 1] == 1)) {
                        perimeter -= 1;
                    }
                    // Bottom
                    if ((row < rows - 1) && (grid[row + 1][col] == 1)) {
                        perimeter -= 1;
                    }
                    // Left
                    if ((col > 0) && (grid[row][col - 1] == 1)) {
                        perimeter -= 1;
                    }
                }

            }
        }

        return perimeter;
    }

    /*
    Time complexity: O(m*n)
    Space complexity: O(1)
     */
    public static int getLandPerimeterByCheckingUpAndLeftSide(final int[][] grid) {
        int perimeter = 0;

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {

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

}
