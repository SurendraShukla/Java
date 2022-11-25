package me.surendra.leetcode.backtracking;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class WordSearchTest {

    private boolean callMethod(final char[][] board, final String word) {
        return new WordSearch().exist(board, word);
    }

    private char[][] getBoard1() {
        final char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        return board;
    }

    private char[][] getBoard2() {
        final char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'E', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        return board;
    }

    @Test
    public void test1() {
        assertThat(callMethod(getBoard1(), "ABCCED"), equalTo(true));
        assertThat(callMethod(getBoard1(), "SEE"), equalTo(true));
        assertThat(callMethod(getBoard1(), "ABCB"), equalTo(false));
    }

    @Test
    public void test2() {
        assertThat(callMethod(getBoard2(), "ABCESEFSADEE"), equalTo(true));
        assertThat(callMethod(getBoard2(), "ABCEFSADEESE"), equalTo(true));
    }

}
