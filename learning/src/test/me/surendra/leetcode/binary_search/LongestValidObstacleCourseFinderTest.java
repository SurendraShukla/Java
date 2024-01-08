package me.surendra.leetcode.binary_search;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LongestValidObstacleCourseFinderTest {

    private final LongestValidObstacleCourseFinder longestValidObstacleCourseFinder = new LongestValidObstacleCourseFinder();

    private int[] callMethod(final int[] obstacles) {
        return longestValidObstacleCourseFinder.longestObstacleCourseAtEachPosition(obstacles);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{1, 2, 3, 2}),
            equalTo(new int[]{1, 2, 3, 3})
        );

        assertThat(
            callMethod(new int[]{2, 2, 1}),
            equalTo(new int[]{1, 2, 1})
        );

        assertThat(
            callMethod(new int[]{3, 1, 5, 6, 4, 2}),
            equalTo(new int[]{1, 1, 2, 3, 2, 2})
        );

        assertThat(
            callMethod(new int[]{5, 1, 5, 5, 1, 3, 4, 5, 1, 4}),
            equalTo(new int[]{1, 1, 2, 3, 2, 3, 4, 5, 3, 5})
        );
    }

}
