package me.surendra.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 */
public class MergeIntervals {

    /*
        Time Complexity - O(n log n)
        Space Complexity - 0(n)
     */
    public int[][] mergeItFirst(final int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        final LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            final int[] interval = intervals[i];
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            // otherwise, there is overlap, so we merge the current and previous intervals.
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    /*
        Time Complexity - O(n log n)
        Space Complexity - 0(n)
     */
    public int[][] merge(final int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        final List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if ((i == intervals.length - 1) ||
                (intervals[i][1] < intervals[i + 1][0])
            ) {
                merged.add(intervals[i]);
            } else {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    /*
        Time Complexity - O(n log n)
        Space Complexity - 0(n)
     */
    public int[][] mergeSelfThought(final int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        final List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {

            final int[] currentInterval = intervals[i];
            if (previousInterval[0] <= currentInterval[0] &&
                previousInterval[1] < currentInterval[0]
            ) {
                merged.add(previousInterval);
                previousInterval = currentInterval;
            } else {
                previousInterval[1] = Math.max(currentInterval[1], previousInterval[1]);
            }
        }

        merged.add(previousInterval);
        return merged.toArray(new int[merged.size()][]);
    }


}
