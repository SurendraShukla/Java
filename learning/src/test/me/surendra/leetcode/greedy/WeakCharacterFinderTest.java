package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class WeakCharacterFinderTest {

    private int callMethod(final int[][] properties) {
        return new WeakCharacterFinder().numberOfWeakCharacters(properties);
    }

    @Test
    public void test1() {
        assertThat(callMethod(
                new int[][]{{5, 5}, {6, 3}, {3, 6}}),
            equalTo(0)
        );
    }

    @Test
    public void test2() {
        assertThat(callMethod(
                new int[][]{{2, 2}, {3, 3}}),
            equalTo(1)
        );
    }

    @Test
    public void test3() {
        assertThat(callMethod(
                new int[][]{{1, 5}, {10, 4}, {4, 3}}),
            equalTo(1)
        );
    }

    @Test
    public void notSure() {
        assertThat(callMethod(
                new int[][]{{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}}),
            equalTo(2)
        );
    }


    @Test
    public void loopBreak() {
        assertThat(callMethod(
                new int[][]{{7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}}),
            equalTo(6)
        );
    }

}
