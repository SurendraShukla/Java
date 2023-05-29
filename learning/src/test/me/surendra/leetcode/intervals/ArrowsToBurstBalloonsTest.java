package me.surendra.leetcode.intervals;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ArrowsToBurstBalloonsTest {

    private final ArrowsToBurstBalloons arrowsToBurstBalloons = new ArrowsToBurstBalloons();

    private int callMethod(final int[][] points) {
        return arrowsToBurstBalloons.findMinArrowShotsByBalloonStartSort(points);
//        return arrowsToBurstBalloons.findMinArrowShotsByBalloonEndSort(points);
    }

    @Test
    public void test() {
        assertThat(callMethod(
                new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}),
            equalTo(4)
        );

        assertThat(callMethod(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{1, 6}, {2, 8}, {7, 12}, {10, 16}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{1, 10}, {2, 3}, {3, 4}, {5, 6}, {6, 8}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{1, 2}, {2, 10}, {3, 4}, {5, 6}, {7, 8}}),
            equalTo(4)
        );

        assertThat(callMethod(
                new int[][]{{1, 2}, {2, 10}, {3, 7}, {4, 8}, {5, 9}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}, {5, 9}}),
            equalTo(1)
        );

        assertThat(callMethod(
                new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}, {5, 9}, {6, 10}}),
            equalTo(2)
        );

        assertThat(callMethod(
                new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}),
            equalTo(2)
        );
    }

}
