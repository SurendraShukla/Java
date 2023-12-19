package me.surendra.leetcode.array.easy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ImageSmootherTest {

    private final ImageSmoother imageSmoother = new ImageSmoother();

    private int[][] callMethod(final int[][] img) {
        return imageSmoother.findAverageOfItsNeighbourAtIndex(img);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}),
            equalTo(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})
        );

        assertThat(
            callMethod(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}}),
            equalTo(new int[][]{{137, 141, 137}, {141, 138, 141}, {137, 141, 137}})
        );
    }

}
