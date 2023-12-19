package me.surendra.leetcode.graph.bfs;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/">Shortest Path in a Grid with Obstacles Elimination</a>
 */
public class ShortestPathWithObstaclesElimination {

    class StepState {
        int steps;
        int row;
        int col;
        int k;

        public StepState(final int row, final int col, final int steps, final int k) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.k = k;
        }

        @Override
        public int hashCode() {
            return (this.row + 1) * (this.col + 1) * this.k;
        }

        @Override
        public boolean equals(final Object other) {
            final StepState newState = (StepState) other;
            return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", this.row, this.col, this.k);
        }
    }

    public int shortestPath(final int[][] grid, final int k) {
        final int rowMax = grid.length;
        final int colMax = grid[0].length;
        if (k >= rowMax * colMax) {
            return (rowMax + colMax) - 1;
        }
        final int[] rows = {0, 1, 0, -1};
        final int[] cols = {1, 0, -1, 0};
        final Set<StepState> seen = new HashSet<>();
        final Queue<StepState> q = new LinkedList<>();

        q.add(new StepState(0, 0, 0, k));

        while (!q.isEmpty()) {
            final StepState currentStepState = q.remove();
            final int row = currentStepState.row;
            final int col = currentStepState.col;
            final int steps = currentStepState.steps;
            final int leftK = currentStepState.k;

            if (row == rowMax - 1 && col == colMax - 1) {
                return steps;
            }

            for (int d = 0; d < rows.length; d++) {
                final int nextRow = row + rows[d];
                final int nextCol = col + cols[d];

                if (nextRow < 0 || nextRow >= rowMax ||
                    nextCol < 0 || nextCol >= colMax
                ) {
                    continue;
                }
                final StepState nextStepState = new StepState(nextRow, nextCol, steps + 1, leftK - grid[nextRow][nextCol]);
                if (nextStepState.k < 0 || seen.contains(nextStepState)) {
                    continue;
                }
                q.add(nextStepState);
                seen.add(nextStepState);
            }
        }

        return -1;
    }

}
