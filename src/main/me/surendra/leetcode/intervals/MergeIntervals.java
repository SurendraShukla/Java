package me.surendra.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MergeIntervals {

    /*
        Time Complexity - O( n(log)n + n)
        Space Complexity - 0(n)
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
//        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        final Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < intervals.length-1; i++) {
            int firstIntervalStart = intervals[i][0];
            int firstIntervalEnd = intervals[i][1];
            int secondIntervalStart = intervals[i+1][0];
            int secondIntervalEnd = intervals[i+1][1];
            if(firstIntervalEnd < secondIntervalStart) {
                hashMap.put(firstIntervalStart, firstIntervalEnd);
                hashMap.put(secondIntervalStart, secondIntervalEnd);
            }else{
                int intervalEnd = secondIntervalEnd < firstIntervalEnd ? firstIntervalEnd : secondIntervalEnd;
                intervals[i+1][0] = firstIntervalStart;
                intervals[i+1][1] = intervalEnd;
                hashMap.put(firstIntervalStart, intervalEnd);
            }
        }

        int[][] actual = new int[hashMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            actual[i][0] = entry.getKey();
            actual[i][1] = entry.getValue();
            i++;
        }
        return actual;
    }

}
