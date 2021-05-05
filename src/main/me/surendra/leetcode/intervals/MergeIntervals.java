package me.surendra.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 */
public class MergeIntervals {

    /*
        Time Complexity - O( n(log)n + n)
        Space Complexity - 0(n)
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        final List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if ((i == intervals.length-1) ||
                (intervals[i][1] < intervals[i+1][0])
            ) {
                merged.add(intervals[i]);
                continue;
            }
            intervals[i+1][0] = intervals[i][0];
            intervals[i+1][1] = Math.max(intervals[i+1][1], intervals[i][1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] mergeItFirst(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        final LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);

            // otherwise, there is overlap, so we merge the current and previous intervals.
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
