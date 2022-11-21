package me.surendra.leetcode.array;


/**
 * @see <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */
public class SudokuValidator {

    /*
        Time Complexity - O(n ^ 2)
        Space Complexity - O(n)
     */
    public boolean isValidSudoku(final char[][] board) {
        final int[][] rowVisited = new int[9][9];
        final int[][] colVisited = new int[9][9];
        final int[][] boxVisited = new int[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                final int val = board[row][col] - '1';
                if (rowVisited[row][val] == 1) {
                    return false;
                }
                if (colVisited[col][val] == 1) {
                    return false;
                }
                final int boxIdx = (row / 3) * 3 + (col / 3);
                if (boxVisited[boxIdx][val] == 1) {
                    return false;
                }
                rowVisited[row][val] = 1;
                colVisited[col][val] = 1;
                boxVisited[boxIdx][val] = 1;
            }
        }

        return true;
    }

}
