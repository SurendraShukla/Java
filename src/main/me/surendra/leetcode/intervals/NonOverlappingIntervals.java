package me.surendra.leetcode.intervals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/non-overlapping-intervals/">Non-overlapping Intervals</a>
 */
public class NonOverlappingIntervals {

    /*
        Time Complexity - O(n log n), sorting takes n log n
        Space Complexity - O(n)
     */
    public int eraseOverlapIntervals(final int[][] intervals) {
        final List<int[]> intervalList = Arrays.stream(intervals)
            .sorted((interval1, interval2) -> interval1[0] - interval2[0])
            .collect(Collectors.toList());


        int mergeIntervalCount = 0;
        int[] previousInterval = intervalList.get(0);
        /*
            Greedy Approach to solve the problem.
            If two intervals are overlapping,
                Remove the interval that has the longer end point.
                The longer interval will always overlap with more or the same number of future intervals compared to the shorter one
         */
        for (int i = 1; i < intervalList.size(); i++) {
            final int[] currentInterval = intervalList.get(i);
            final int currentStartInterval= currentInterval[0];
            final int previousEndInterval = previousInterval[1];

            if (currentStartInterval < previousEndInterval) {
                int currentEndInterval = currentInterval[1];
                if (currentEndInterval < previousEndInterval) {
                    previousInterval = currentInterval;
                }
                mergeIntervalCount++;
            }else{
                previousInterval = currentInterval;
            }

        }
        return mergeIntervalCount;
    }

}
