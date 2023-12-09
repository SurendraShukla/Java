package me.surendra.leetcode.graph.topological_sort;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ParallelCoursesIIITest {

    private final ParallelCoursesIII parallelCoursesIII = new ParallelCoursesIII();

    @Test
    public void test1() {
        final int actual = parallelCoursesIII.minimumTime(3,
            new int[][]{{1, 3}, {2, 3}},
            new int[]{3, 2, 5}
        );

        assertThat(actual, equalTo(8));
    }

    @Test
    public void test2() {
        final int actual = parallelCoursesIII.minimumTime(5,
            new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}},
            new int[]{1, 2, 3, 4, 5}
        );

        assertThat(actual, equalTo(12));
    }

    @Test
    public void test3() {
        final int actual = parallelCoursesIII.minimumTime(9,
            new int[][]{{2, 7}, {2, 6}, {3, 6}, {4, 6}, {7, 6}, {2, 1}, {3, 1}, {4, 1}, {6, 1}, {7, 1}, {3, 8}, {5, 8}, {7, 8}, {1, 9}, {2, 9}, {6, 9}, {7, 9}},
            new int[]{9, 5, 9, 5, 8, 7, 7, 8, 4}
        );

        assertThat(actual, equalTo(32));
    }

}
