package me.surendra.leetcode.array.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/queens-that-can-attack-the-king/">Queens That Can Attack the King</a>
 */
public class KingAttackedByQueen {

    final int[][] chessBoard = new int[8][8];
    int kingRowPosition;
    int kingColPosition;
    final List<List<Integer>> returnList = new ArrayList<>();

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {
        final List<List<Integer>> list = new ArrayList<>();
        final int[][] board = new int[8][8];
        for (final int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }

        final int kingRowIndex = king[0];
        final int kingColIndex = king[1];
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1,-1}, {-1, 1}, {1, -1}, {1, 1}};

        for (final int[] direction : directions) {
            for(
                int row = kingRowIndex + direction[0], col = kingColIndex + direction[1];
                row>=0 && row<8 && col>=0 && col<8;
                row+=direction[0], col+=direction[1]
            ) {
                if(board[row][col] == 1) {
                    list.add(Arrays.asList(row, col));
                    break;
                }
            }
        }

        return list;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<List<Integer>> queensAttackTheKingUsingDirectionMethods(int[][] queens, int[] king) {

        for (final int[] queen : queens) {
            chessBoard[queen[0]][queen[1]] = 1;
        }

        kingRowPosition = king[0];
        kingColPosition = king[1];

        populateNearestQueenAttackingFromNorthWest();
        populateNearestQueenAttackingFromNorthEast();
        populateNearestQueenAttackingFromNorth();
        populateNearestQueenAttackingFromWest();
        populateNearestQueenAttackingFromEast();
        populateNearestQueenAttackingFromSouth();
        populateNearestQueenAttackingFromSouthWest();
        populateNearestQueenAttackingFromSouthEast();

        return returnList;
    }

    private void populateNearestQueenAttackingFromSouthEast() {
        for (int row = kingRowPosition+1, col = kingColPosition+1; row<8 && col<8; row++, col++) {
            if(chessBoard[row][col] == 1) {
                returnList.add(Arrays.asList(row, col));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromSouthWest() {
        for (int row = kingRowPosition+1, col = kingColPosition-1; row<8 && col>=0; row++, col--) {
            if(chessBoard[row][col] == 1) {
                returnList.add(Arrays.asList(row, col));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromSouth() {
        for (int row = kingRowPosition+1; row<8; row++) {
            if(chessBoard[row][kingColPosition] == 1) {
                returnList.add(Arrays.asList(row, kingColPosition));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromEast() {
        for (int col = kingColPosition+1; col<8; col++) {
            if(chessBoard[kingRowPosition][col] == 1) {
                returnList.add(Arrays.asList(kingRowPosition, col));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromWest() {
        for(int col = kingColPosition-1; col>=0; col--) {
            if(chessBoard[kingRowPosition][col] == 1) {
                returnList.add(Arrays.asList(kingRowPosition, col));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromNorth() {
        for(int row = kingRowPosition-1; row>=0; row--) {
            if(chessBoard[row][kingColPosition] == 1) {
                returnList.add(Arrays.asList(row, kingColPosition));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromNorthEast() {
        for (int row = kingRowPosition-1, col = kingColPosition+1; row>=0 && col<8; row--, col++) {
            if(chessBoard[row][col] == 1) {
                returnList.add(Arrays.asList(row, col));
                return;
            }
        }
    }

    private void populateNearestQueenAttackingFromNorthWest() {
        for(int row = kingRowPosition-1, col = kingColPosition-1; row>=0 && col>=0; row--, col--) {
            if(chessBoard[row][col] == 1) {
                returnList.add(Arrays.asList(row, col));
                return;
            }
        }
    }

}
