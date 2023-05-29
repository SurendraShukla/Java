package me.surendra.leetcode.graph.adjacency.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UnweightedAndNonDirectedGraphTest {

    private AdjacencyList adjacencyList;

    @Before
    public void setUp() throws Exception {
        adjacencyList = new AdjacencyList(8);
        final int[][] edges = {{2, 1},{1, 0},{0, 3},{3, 7},{3, 4},{7, 4},{7, 6},{6, 4},{6, 5},{4, 5}};
        adjacencyList.addEdges(edges);
    }

    @Test
    public void test1() {
        final List<Integer> expectedShortestPath = Arrays.asList(0, 3, 7);

        // execute
        final List<Integer> actualShortestPath = adjacencyList.findTheShortestPath(0, 7);

        assertThat(actualShortestPath.size(), equalTo(expectedShortestPath.size()));
        assertTrue(actualShortestPath.containsAll(expectedShortestPath) && expectedShortestPath.containsAll(actualShortestPath));
    }

    @Test
    public void test2() {

        final List<Integer> expectedShortestPath = Arrays.asList(2, 1, 0, 3, 7, 6);

        // execute
        final List<Integer> actualShortestPath = adjacencyList.findTheShortestPath(2, 6);

        assertThat(actualShortestPath.size(), equalTo(expectedShortestPath.size()));
        assertTrue(actualShortestPath.containsAll(expectedShortestPath) && expectedShortestPath.containsAll(actualShortestPath));
    }

}
