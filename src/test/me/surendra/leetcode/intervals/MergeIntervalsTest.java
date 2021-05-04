package me.surendra.leetcode.intervals;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MergeIntervalsTest {

    @Test
    public void mergeOne() {

        int[][] input = {{1,3}, {8,10}, {2,6}, {15,18}};
        int [][] expected = {{1,6}, {8,10}, {15,18}};

        int[][] actual = MergeIntervals.merge(input);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void mergeAll() {
        int[][] input = {{1,4}, {4,5}};
        int [][] expected = {{1,5}};

        int[][] actual = MergeIntervals.merge(input);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void noMerge() {
        int[][] input = {{1,4},{5,6}};
        int [][] expected = {{1,4},{5,6}};

        int[][] actual = MergeIntervals.merge(input);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void justOneInterval() {
        int[][] input = {{1,3}};
        int [][] expected = {{1,3}};

        int[][] actual = MergeIntervals.merge(input);

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void secondIntervalCompletelyMergesIntoFirstOne() {
        int[][] input = {{1,4},{2,3}};
        int [][] expected = {{1,4}};

        int[][] actual = MergeIntervals.merge(input);

        assertThat(actual, equalTo(expected));
    }

}
