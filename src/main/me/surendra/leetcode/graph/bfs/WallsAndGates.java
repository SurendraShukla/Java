package me.surendra.leetcode.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="">Walls and Gates</a>
 */
public class WallsAndGates {

    /*
        Time Complexity - O(m * n) m is rows, n is cols
        Space Complexity - O(m * n) m is rows, n is cols
     */
    public void wallsAndGates(final int[][] rooms) {
        final int rowMax = rooms.length;
        final int colMax = rooms[0].length;
        final Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new int[]{row, col});
                }
            }
        }

        final List<int[]> directions = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0}
        );
        while (!q.isEmpty()) {
            final int[] position = q.remove();
            final int row = position[0];
            final int col = position[1];

            for (int[] direction: directions) {
                final int nextRow = direction[0] + row;
                final int nextCol = direction[1] + col;
                if (nextRow < 0 || nextRow >= rowMax ||
                    nextCol < 0 || nextCol >= colMax ||
                    rooms[nextRow][nextCol] != 2147483647
                ) {
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[row][col] + 1;
                q.add(new int[]{nextRow, nextCol});
            }
        }
    }

}
