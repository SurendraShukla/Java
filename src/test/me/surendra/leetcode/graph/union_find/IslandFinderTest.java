package me.surendra.leetcode.graph.union_find;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class IslandFinderTest {

    private final IslandFinder islandFinder = new IslandFinder();

    private int callDfs(final char[][] grid) {
        final IslandFinder.DFS dfs = islandFinder.new DFS();
        return dfs.numIslands(grid);
    }

    private int callUnionFind(final char[][] grid) {
        final IslandFinder.UF unionFind = islandFinder.new UF();
        return unionFind.numIslands(grid);
    }

    private int callAndVerify(final char[][] grid) {
//        final int noOfIslands = callDfs(grid);
        final int noOfIslands = callUnionFind(grid);

        return noOfIslands;
    }

    @Test
    public void islandsOnly() {
        final char[][] grid = {{'1'}};

        assertThat(callAndVerify(grid), equalTo(1));
    }

    @Test
    public void islands1() {
        final char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        assertThat(callAndVerify(grid), equalTo(1));
    }

    @Test
    public void islands3() {
        final char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        assertThat(callAndVerify(grid), equalTo(3));
    }

    @Test
    public void islands2() {
        final char[][] grid = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };

        assertThat(callAndVerify(grid), equalTo(1));
    }

}
