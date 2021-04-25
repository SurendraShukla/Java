package me.surendra.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static me.surendra.leetcode.Island.islandPerimeter;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IslandTest extends TestCase {

    @Test
    public void test1() {
        int[][] grid = {
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}};
        System.out.println();
        assertThat(islandPerimeter(grid), equalTo(16));
    }

    @Test
    public void test2() {
        int[][] grid = {{1}};
        assertThat(islandPerimeter(grid), equalTo(4));
    }

    @Test
    public void test3() {
        int[][] grid = {{1,0}};
        assertThat(islandPerimeter(grid), equalTo(4));
    }

}
