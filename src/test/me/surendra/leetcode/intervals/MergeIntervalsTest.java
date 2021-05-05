package me.surendra.leetcode.intervals;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MergeIntervalsTest {

    @Test
    public void mergeOne() {
        int[][] input = {{1,3}, {8,10}, {2,6}, {15,18}};
        int [][] expected = {{1,6}, {8,10}, {15,18}};

        assertThat(MergeIntervals.merge(input), equalTo(expected));
        assertThat(MergeIntervals.mergeItFirst(input), equalTo(expected));
    }

    @Test
    public void mergeAll() {
        int[][] input = {{1,4}, {4,5}};
        int [][] expected = {{1,5}};

        assertThat(MergeIntervals.merge(input), equalTo(expected));
        assertThat(MergeIntervals.mergeItFirst(input), equalTo(expected));
    }

    @Test
    public void noMerge() {
        int[][] input = {{1,4},{5,6}};
        int [][] expected = {{1,4},{5,6}};

        assertThat(MergeIntervals.merge(input), equalTo(expected));
        assertThat(MergeIntervals.mergeItFirst(input), equalTo(expected));
    }

    @Test
    public void justOneInterval() {
        int[][] input = {{1,3}};
        int [][] expected = {{1,3}};

        assertThat(MergeIntervals.merge(input), equalTo(expected));
        assertThat(MergeIntervals.mergeItFirst(input), equalTo(expected));
    }

    @Test
    public void secondIntervalCompletelyMergesIntoFirstOne() {
        int[][] input = {{1,4},{2,3}};
        int [][] expected = {{1,4}};

        assertThat(MergeIntervals.merge(input), equalTo(expected));
        assertThat(MergeIntervals.mergeItFirst(input), equalTo(expected));
    }

}
