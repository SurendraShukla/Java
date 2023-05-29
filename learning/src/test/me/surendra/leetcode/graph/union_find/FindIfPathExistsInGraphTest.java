package me.surendra.leetcode.graph.union_find;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FindIfPathExistsInGraphTest {

    private final FindIfPathExistsInGraph findIfPathExistsInGraph = new FindIfPathExistsInGraph();

    private boolean callMethod(final int n, final int[][] edges, final int source, final int destination) {
        return findIfPathExistsInGraph.validPathUsingUf(n, edges, source, destination);
//        return findIfPathExistsInGraph.validPathUsingBfs(n, edges, source, destination);
    }

    @Test
    public void pathExists() {
        final int[][] edges = {{0, 1}, {1, 2}, {2, 0}};

        assertThat(
            callMethod(3, edges, 0, 2),
            equalTo(true)
        );
    }

    @Test
    public void pathDoesNotExists() {
        final int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        assertThat(
            callMethod(6, edges, 0, 5),
            equalTo(false)
        );
    }
}
