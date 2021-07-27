package me.surendra.leetcode.graph;

import junit.framework.TestCase;
import org.junit.Test;

import static me.surendra.leetcode.graph.IslandPerimeter.getLandPerimeterByCheckingAtAllFourSides;
import static me.surendra.leetcode.graph.IslandPerimeter.getLandPerimeterByCheckingUpAndLeftSide;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IslandPerimeterTest extends TestCase {

    @Test
    public void test1() {
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        assertThat(getLandPerimeterByCheckingAtAllFourSides(grid), equalTo(16));
        assertThat(getLandPerimeterByCheckingUpAndLeftSide(grid), equalTo(16));
    }

    @Test
    public void test2() {
        int[][] grid = {{1}};
        assertThat(getLandPerimeterByCheckingAtAllFourSides(grid), equalTo(4));
        assertThat(getLandPerimeterByCheckingUpAndLeftSide(grid), equalTo(4));
    }

    @Test
    public void test3() {
        int[][] grid = {{1,0}};
        assertThat(getLandPerimeterByCheckingAtAllFourSides(grid), equalTo(4));
        assertThat(getLandPerimeterByCheckingUpAndLeftSide(grid), equalTo(4));
    }

}
