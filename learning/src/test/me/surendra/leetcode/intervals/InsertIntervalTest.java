package me.surendra.leetcode.intervals;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class InsertIntervalTest {

    private int[][] callMethod(final int[][] intervals, final int[] newInterval) {
        return new InsertInterval().insert(intervals, newInterval);
    }

    @Test
    public void emptyIntervals() {
        final int[][] intervals = {};
        final int[] newInterval = {5, 7};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{5, 7}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void noIntervals() {
        final int[][] intervals = {{}};
        final int[] newInterval = {5, 7};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{5, 7}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void oneInterval() {
        final int[][] intervals = {{1, 3}};
        final int[] newInterval = {5, 7};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{1, 3}, {5, 7}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void oneInterval2() {
        final int[][] intervals = {{1, 3}};
        final int[] newInterval = {2, 7};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{1, 7}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void insertIntervalIsHasSmallerStartAndEndTime() {
        final int[][] intervals = {{1, 3}};
        final int[] newInterval = {0, 0};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{0, 0}, {1, 3}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test1() {
        final int[][] intervals = {{1, 3}, {6, 9}};
        final int[] newInterval = {2, 5};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{1, 5}, {6, 9}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        final int[] newInterval = {4, 8};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void subInterval() {
        final int[][] intervals = {{1, 5}};
        final int[] newInterval = {2, 3};

        // execute
        final int[][] actual = callMethod(intervals, newInterval);

        final int[][] expected = {{1, 5}};
        assertThat(actual, equalTo(expected));
    }

}
