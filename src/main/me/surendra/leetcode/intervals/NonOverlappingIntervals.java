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
    public int eraseOverlapIntervals(int[][] intervals) {
        final List<int[]> intervalList = Arrays.stream(intervals)
            .sorted((interval1, interval2) -> interval1[0] - interval2[0])
            .collect(Collectors.toList());


        int mergeIntervalCount = 0;
        int[] previousInterval = intervalList.get(0);

        /*
            Greedy Approach to solve problem
         */
        for (int i = 1; i < intervalList.size(); i++) {
            int[] currentInterval = intervalList.get(i);
            if (currentInterval[0] < previousInterval[1]) {
                if (currentInterval[1] < previousInterval[1]) {
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
