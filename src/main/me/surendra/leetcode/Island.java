package me.surendra.leetcode;

public class Island {

    /**
     * @param grid
     * @return int
     * @see <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
     */
    public static int islandPerimeter(final int[][] grid) {
        int perimeterOfTheIsland = 0;
        for (int row = 0; row< grid.length; row++) {
            for (int col = 0; col< grid[row].length; col++) {
                if(grid[row][col] == 0) {
                    continue;
                }else{
                    int perimeter = isNonWaterCell(grid, row, col - 1, grid.length, grid[row].length) // Left
                        + isNonWaterCell(grid, row, col + 1, grid.length, grid[row].length) // Right
                        + isNonWaterCell(grid, row - 1, col, grid.length, grid[row].length) // Top
                        + isNonWaterCell(grid, row + 1, col, grid.length, grid[row].length);
                    if(perimeter > 0) {
                        perimeterOfTheIsland+= perimeter;
                    }
                }
            }
        }
        return perimeterOfTheIsland;
    }

    private static int isNonWaterCell(final int[][] grid, final int row, final int col, final int rows, final int columns) {
        if(row<0 || row>=rows) {
            return 1;
        }
        if(col<0 || col>=columns) {
            return 1;
        }
        return (grid[row][col] == 0) ? 1 : 0;
    }


}
