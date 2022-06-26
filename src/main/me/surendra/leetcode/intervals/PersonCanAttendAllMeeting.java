package me.surendra.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ses <a href="https://leetcode.com/problems/meeting-rooms/">Meeting Rooms</a>
 */
public class PersonCanAttendAllMeeting {

    /*
        Time complexity : O(n log n) Sorting Intervals
        Space complexity: O(1) No external space is allocated

        Overlapping If End Time is Greater than Start Time of Next Meeting
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }


    public boolean canAttendMeetingsByCheckingBothTime(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = intervals[i - 1];
            int previousIntervalStartTime= previousInterval[0];
            int previousIntervalEndTime  = previousInterval[1];
            int currentIntervalStartTime = intervals[i][0];
            if ((currentIntervalStartTime >= previousIntervalStartTime) && (currentIntervalStartTime < previousIntervalEndTime)) {
                return false;
            }
        }
        return true;
    }

}
