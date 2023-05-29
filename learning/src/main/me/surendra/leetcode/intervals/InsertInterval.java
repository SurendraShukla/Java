package me.surendra.leetcode.intervals;


import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/insert-interval/">Insert Interval</a>
 */
public class InsertInterval {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public int[][] insert(final int[][] intervals, final int[] newInterval) {
        if (intervals.length < 1 || intervals[0].length < 1) {
            return new int[][]{newInterval};
        }
        boolean intervalNotMerged = true;
        final int[] insertInterval = newInterval;
        final List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            final int[] currentInterval = intervals[i];
            // first n non overlapping intervals
            if (intervalNotMerged && currentInterval[1] < insertInterval[0]) {
                mergedIntervals.add(currentInterval);
                continue;
            }
            // first overlapping intervals
            if (intervalNotMerged) {
                mergedIntervals.add(newInterval);
                intervalNotMerged = false;
            }
            final int[] previousInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            // Overlapping intervals
            if (previousInterval[1] >= currentInterval[0]) {
                previousInterval[0] = Math.min(previousInterval[0], currentInterval[0]);
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
                mergedIntervals.set(mergedIntervals.size() - 1, previousInterval);
            } else {
                mergedIntervals.add(currentInterval);
            }
        }

        if (intervalNotMerged) {
            mergedIntervals.add(newInterval);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}
