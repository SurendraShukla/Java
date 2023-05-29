package me.surendra.leetcode.heap;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SingleThreadedCPUTest {

    private final SingleThreadedCPU singleThreadedCPU = new SingleThreadedCPU();

    private int[] callMethod(final int[][] tasks) {
        return singleThreadedCPU.getOrder(tasks);
    }

    @Test
    public void test1() {
        final int[][] tasks = {{7, 1}, {6, 3}, {1, 3}};

        final int[] expected = {2, 1, 0};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void test2() {
        final int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};

        final int[] expected = {0, 2, 3, 1};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void test3() {
        final int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};

        final int[] expected = {4, 3, 2, 0, 1};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void test4() {
        final int[][] tasks = {{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24},
            {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};

        final int[] expected = {6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void test5() {
        final int[][] tasks = {{23, 40}, {10, 32}, {12, 18}, {10, 39}, {25, 4}, {18, 12},
            {38, 18}, {36, 1}, {26, 5}, {45, 35}, {5, 43}, {19, 19}, {46, 41}, {25, 22},
            {29, 17}, {26, 33}, {49, 45}, {43, 44}, {50, 2}};

        final int[] expected = {10, 7, 4, 18, 8, 5, 14, 2, 6, 11, 13, 1, 15, 9, 3, 0, 12, 17, 16};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void timeLimitExceed1() {
        final int[][] tasks = {{1000000000, 1000000000}};

        final int[] expected = {0};
        assertThat(callMethod(tasks), equalTo(expected));
    }

    @Test
    public void timeLimitExceed2() {
        final int[][] tasks = {{100, 100}, {1000000000, 1000000000}};

        final int[] expected = {0, 1};
        assertThat(callMethod(tasks), equalTo(expected));
    }

}
