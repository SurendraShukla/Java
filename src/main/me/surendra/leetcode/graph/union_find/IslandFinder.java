package me.surendra.leetcode.graph.union_find;


/**
 * @see <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 */
public class IslandFinder {

    public class DFS {
        /*
            Time complexity : O(n * m) M is no. of rows & N is no. of cols
            Space complexity: O(n * m) M is no. of rows & N is no. of cols
         */
        int rowLen;
        int colLen;
        public int numIslands(final char[][] grid) {
            rowLen = grid.length;
            colLen = grid[0].length;

            int numIslands = 0;
            for (int row = 0; row < rowLen; row++) {
                for (int col = 0; col < colLen; col++) {
                    if (grid[row][col] == '1') {
                        numIslands++;
                        dfs(grid, row, col);
                    }
                }
            }
            return numIslands;
        }

        private void dfs(final char[][] grid, final int row, final int col) {
            if (row < 0 || col < 0 || row >= rowLen || col >= colLen || grid[row][col] == '0') {
                return;
            }
            grid[row][col] = '0';
            dfs(grid, row - 1, col); // Top
            dfs(grid, row, col + 1); // Right
            dfs(grid, row + 1, col); // Bottom
            dfs(grid, row, col - 1); // Left
        }

    }

    public class UF {

        /*
            Time complexity : O(n * m) M is no. of rows & N is no. of cols
            Space complexity: O(n * m) M is no. of rows & N is no. of cols
         */
        int rowMax;
        int colMax;
        public int numIslands(final char[][] grid) {
            rowMax = grid.length;
            colMax = grid[0].length;
            if (grid == null || grid.length == 0)
                return 0;

            final UnionFind uf = new UnionFind(grid.length * grid[0].length);
            int zeros = 0;

            for (int row = 0; row < rowMax; row++) {
                for (int col = 0; col < colMax; col++) {
                    final int node1 = getIdx(row, col);
                    if (grid[row][col] == '1') {
                        grid[row][col] = '0';
                        // forward
                        if (row + 1 < rowMax && grid[row + 1][col] == '1') {
                            final int leftNode = getIdx(row + 1, col);
                            uf.union(node1, leftNode);
                        }
                        // down
                        if (col + 1 < colMax && grid[row][col + 1] == '1') {
                            final int bottomNode = getIdx(row, col + 1);
                            uf.union(node1, bottomNode);
                        }
                    } else {
                        zeros++;
                    }
                }
            }

            return uf.getCount() - zeros;
        }

        private int getIdx(final int row, final int col) {
            return (row * colMax) + col;
        }

    }

}
