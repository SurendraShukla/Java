package me.surendra.leetcode.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProvinceFinderTest {

    private int callMethod(final int[][] input) {
        return new ProvinceFinder().findCircleNum(input);
    }

    @Test
    public void test0() {
        final int[][] input = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };

        assertThat(callMethod(input), equalTo(1));
    }

    @Test
    public void test1() {
        final int[][] input = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };

        assertThat(callMethod(input), equalTo(2));
    }

    @Test
    public void test2() {
        final int[][] input = {
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };

        assertThat(callMethod(input), equalTo(3));
    }

    @Test
    public void test3() {
        final int[][] input = {
            {1,1,1,0,0},
            {1,1,0,0,1},
            {1,0,1,0,0},
            {0,0,0,1,1},
            {0,1,0,1,1}
        };

        assertThat(callMethod(input), equalTo(1));
    }

    @Test
    public void test4() {
        final int[][] input = {
            {1,1,1,0},
            {1,1,0,0},
            {1,0,1,0},
            {0,0,0,1},
        };

        assertThat(callMethod(input), equalTo(2));
    }

    @Test
    public void test5() {
        final int[][] input = {
            {1,1,1,0},
            {1,1,0,0},
            {1,0,1,1},
            {0,0,1,1},
        };

        assertThat(callMethod(input), equalTo(1));
    }

    @Test
    public void test6() {
        // {0,1,7} {3,5,6} {
        final int[][] input = {
            {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
            {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
            {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
            {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
            {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}
        };
        assertThat(callMethod(input), equalTo(3));
    }


}
