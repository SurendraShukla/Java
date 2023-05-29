package me.surendra.leetcode.backtracking;

/**
 * @see <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 */
public class WordSearch {
    char[][] grid;
    int rowMax;
    int colMax;
    int strLastIdx;
    String str;

    /*
        Time Complexity - O(N * 3 ^ L)
                N is the number of cells in the board and
                L is the length of the word to be matched.
        Space Complexity - O(L)
                L is the length of the word to be matched.
     */
    public boolean exist(final char[][] board, final String word) {
        grid = board;
        rowMax = board.length;
        colMax = board[0].length;
        strLastIdx = word.length() - 1;
        str = word;

        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                if (dfsFindsWord(0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsFindsWord(final int strIdx, final int row, final int col) {
        /* Step 1). check the bottom case. */
        if (strIdx == strLastIdx) {
            return true;
        }
        /* Step 2). Check the boundaries. */
        if (row < 0 || row >= rowMax ||
            col < 0 || col >= colMax ||
            strIdx > strLastIdx ||
            str.charAt(strIdx) != grid[row][col]
        ) {
            return false;
        }

        /* Step 3). explore the neighbors in DFS */
        // mark the path before the next exploration
        final char currentChar = grid[row][col];
        grid[row][col] = '#';

        final int[] rowDirection = {0, 1, 0, -1};
        final int[] colDirection = {1, 0, -1, 0};
        for (int idx = 0; idx < 4; idx++) {
            // return without cleanup
            if (dfsFindsWord(strIdx + 1, row + rowDirection[idx], col + colDirection[idx])) {
                return true;
            }
        }

        /* Step 4). clean up and return the result. */
        grid[row][col] = currentChar;
        return false;
    }

}
