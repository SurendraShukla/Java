package me.surendra.leetcode.backtracking;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CampusBikesIITest {

    private int callMethod(final int[][] workers, final int[][] bikes) {
        return new CampusBikesII().assignBikes(workers, bikes);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(
                new int[][]{{0, 0}, {2, 1}},
                new int[][]{{1, 2}, {3, 3}}
            ),
            equalTo(6)
        );

        assertThat(
            callMethod(
                new int[][]{{0, 0}, {1, 1}, {2, 0}},
                new int[][]{{1, 0}, {2, 2}, {2, 1}}
            ),
            equalTo(4)
        );

        assertThat(
            callMethod(
                new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
                new int[][]{{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}}
            ),
            equalTo(4995)
        );

        assertThat(
            callMethod(
                new int[][]{{239, 904}, {191, 103}, {260, 117}, {86, 78}, {747, 62}},
                new int[][]{{660, 8}, {431, 772}, {78, 576}, {894, 481}, {451, 730}, {155, 28}}
            ),
            equalTo(1886)
        );
    }

}
