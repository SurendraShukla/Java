package me.surendra.leetcode.graph.bfs;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RottingOrangesTest {

    private final RottingOranges rottingOranges = new RottingOranges();

    private int callMethod(final int[][] grid) {
        return rottingOranges.orangesRotting(grid);
    }

    @Test
    public void test() {
        assertThat(callMethod(
            new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}),
            equalTo(4)
        );

        assertThat(callMethod(
                new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}),
            equalTo(-1)
        );

        assertThat(callMethod(
                new int[][]{{0, 2}}),
            equalTo(0)
        );
    }

}
