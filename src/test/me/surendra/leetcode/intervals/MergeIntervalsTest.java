package me.surendra.leetcode.intervals;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MergeIntervalsTest {

    private MergeIntervals mergeIntervals = new MergeIntervals();

    private int[][] callMethod(final int[][] input) {
        return mergeIntervals.mergeItFirst(input);
//        return mergeIntervals.merge(input);
//        return mergeIntervals.mergeSelfThought(input);
    }

    @Test
    public void mergeOne() {
        final int[][] input = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        final int [][] expected = {{1, 6}, {8, 10}, {15, 18}};

        assertThat(callMethod(input), equalTo(expected));
    }

    public void mergeAll() {
        final int[][] input = {{1, 4}, {4, 5}};
        final int [][] expected = {{1, 5}};

        assertThat(callMethod(input), equalTo(expected));
    }

    @Test
    public void noMerge() {
        final int[][] input = {{1, 4}, {5, 6}};
        final int [][] expected = {{1, 4}, {5, 6}};

        assertThat(callMethod(input), equalTo(expected));
    }

    @Test
    public void justOneInterval() {
        final int[][] input = {{1, 3}};
        final int [][] expected = {{1, 3}};

        assertThat(callMethod(input), equalTo(expected));
    }

    @Test
    public void secondIntervalCompletelyMergesIntoFirstOne() {
        final int[][] input = {{1, 4}, {2, 3}};
        final int [][] expected = {{1, 4}};

        assertThat(callMethod(input), equalTo(expected));
    }

}
