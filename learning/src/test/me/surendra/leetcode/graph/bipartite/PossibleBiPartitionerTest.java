package me.surendra.leetcode.graph.bipartite;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PossibleBiPartitionerTest {

    private final PossibleBiPartitioner possibleBiPartitioner = new PossibleBiPartitioner();

    private boolean callMethod(final int n, final int[][] dislikes) {
//        return possibleBiPartitioner.possibleBiPartitionUsingBFS(n, dislikes);
        return possibleBiPartitioner.possibleBiPartitionUsingUf(n, dislikes);
    }

    @Test
    public void canPartition() {
        assertThat(callMethod(4,
            new int[][]{{1, 2}, {1, 3}, {2, 4}}),
            equalTo(true)
        );

        assertThat(callMethod(10,
                new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}),
            equalTo(true)
        );
    }

    @Test
    public void canNotPartition() {
        assertThat(callMethod(4,
            new int[][]{{1, 2}, {1, 3}, {2, 3}}),
            equalTo(false)
        );

        assertThat(callMethod(5,
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}),
            equalTo(false)
        );
    }


    @Test
    public void canNotPartitionNeedToCheckForAllGroups() {
        assertThat(callMethod(5,
                new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}),
            equalTo(false)
        );
    }
}
