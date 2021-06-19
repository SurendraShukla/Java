package me.surendra.leetcode.array.chess;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class KingAttackedByQueenTest {

    private List<List<Integer>> callMethod(final int[][] queens, final int[] king) {
        return new KingAttackedByQueen().queensAttackTheKing(queens, king);
    }

    private List<List<Integer>> convertArrayToList(final int[][] twoDArray) {
        final List list = new ArrayList();
        for (int[] array : twoDArray) {
            list.add(Lists.newArrayList(array[0], array[1]));
        }
        return list;
    }

    @Test
    public void test1() {
        final int[] king = {3,4};
        final int[][] queens = {{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3},
            {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3},
            {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}};
        final int[][] twoDArray = {{2, 3}, {1, 4}, {1, 6}, {3, 7}, {4, 3}, {5, 4}, {4, 5}};
        List<List<Integer>> expectedAttackingQueen = convertArrayToList(twoDArray);

        final List<List<Integer>> actualAttackingQueens = callMethod(queens, king);

        assertThat(actualAttackingQueens.size(), equalTo(expectedAttackingQueen.size()));
        assertTrue(actualAttackingQueens.containsAll(expectedAttackingQueen) && expectedAttackingQueen.containsAll(actualAttackingQueens));
    }

    @Test
    public void test2() {
        final int[] king = {3,3};
        final int[][] queens = {{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        final int[][] twoDArray = {{2,2},{3,4},{4,4}};
        List<List<Integer>> expectedAttackingQueen = convertArrayToList(twoDArray);

        final List<List<Integer>> actualAttackingQueens = callMethod(queens, king);

        assertThat(actualAttackingQueens.size(), equalTo(expectedAttackingQueen.size()));
        assertTrue(actualAttackingQueens.containsAll(expectedAttackingQueen) && expectedAttackingQueen.containsAll(actualAttackingQueens));
    }

    @Test
    public void test3() {
        final int[] king = {0,0};
        final int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        final int[][] twoDArray = {{0,1},{1,0},{3,3}};
        List<List<Integer>> expectedAttackingQueen = convertArrayToList(twoDArray);

        final List<List<Integer>> actualAttackingQueens = callMethod(queens, king);

        assertThat(actualAttackingQueens.size(), equalTo(expectedAttackingQueen.size()));
        assertTrue(actualAttackingQueens.containsAll(expectedAttackingQueen) && expectedAttackingQueen.containsAll(actualAttackingQueens));
    }

}
