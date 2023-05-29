package me.surendra.leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/rotting-oranges/description/">Rotting Oranges</a>
 */
public class RottingOranges {

    /*
        Time Complexity - O(m * n) m is rows, n is cols
        Space Complexity - O(m * n) m is rows, n is cols
     */
    int rowMax;
    int colMax;
    int[][] matrix;
    final Queue<int[]> q = new LinkedList<>();
    public int orangesRotting(final int[][] grid) {
        this.matrix = grid;
        rowMax = grid.length;
        colMax = grid[0].length;

        // Step 1). build the initial set of rotten oranges
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        final int[] rows = {0, 1, 0, -1};
        final int[] cols = {1, 0, -1, 0};
        // Step 2). start the rotting process via BFS
        int maxTime = 0;
        while (!q.isEmpty()) {
            final int size = q.size();
            maxTime++;
            for (int i = 0; i < size; i++) {
                final int[] coordinates = q.remove();
                for (int j = 0; j < rows.length; j++) {
                    final int nextRow = coordinates[0] + rows[j];
                    final int nextCol = coordinates[1] + cols[j];
                    if (nextRow < 0 || nextRow >= rowMax ||
                        nextCol < 0 || nextCol >= colMax ||
                        matrix[nextRow][nextCol] != 1
                    ) {
                        continue;
                    }
                    matrix[nextRow][nextCol] = 2;
                    q.add(new int[]{nextRow, nextCol});
                }
            }
        }

        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return maxTime == 0 ? 0 : maxTime - 1;
    }


}
