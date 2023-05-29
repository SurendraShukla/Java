package me.surendra.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * @see <a href="https://leetcode.com/problems/my-calendar-i/">My Calendar I</a>
 */
public class MyCalendarI {

    /*
        Time Complexity - O(n log n)
        Space Complexity- O(n)
     */
    final TreeMap<Integer, Integer> calendar = new TreeMap();
    public boolean bookUsingTreeSet(final int start, final int end) {
        /**
         * Get location (Previous and Next Meeting)
         * where this meeting can be inserted
         */
        final Integer prevMeetingStartTime = calendar.floorKey(start);
        final Integer nextMeetingStartTime = calendar.ceilingKey(start);

        /**
         * New meeting
         *  should start after previous meeting has ended (if its there)
         *  should end before next meeting is going to start (if its there)
         *
         *  prevMeetingStartTime <= start <= end <= nextMeetingStartTime
         */
        if ((prevMeetingStartTime == null || calendar.get(prevMeetingStartTime) <= start) &&
            (nextMeetingStartTime == null || end <= nextMeetingStartTime)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

    /**
        Time Complexity - O(n log n)
        Space Complexity- O(n)


        Keep meeting interval sorted by start time when its getting inserted in the list
        Binary search for location meeting where it can be added.

        Verify calendar meeting at that index is overlapping condition/slot
        Overlapping
            If calendar (some) meeting has started
                but not ended before this meeting start
            Of If this meeting going to start earlier than calendar meeting
                but going to end after the calendar meeting start time
        If no overlap meeting
            Then add meeting at (left) index
     */
    final List<int[]> intervals = new ArrayList<>();
    public boolean bookUsingBinarySearch(final int start, final int end) {
        int left = 0;
        int right = intervals.size() - 1;
        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final int[] midInterval = intervals.get(mid);
            // MidInterval start early
            if (midInterval[0] < start) {
                // It should end early before the next meeting starts
                // If it is not, it is an overlapping
                if (midInterval[1] > start) {
                    return false;
                }
                left = mid + 1;
                // Provided/current meeting started early
            } else {
                // It should end early before the next meeting starts
                // If it is not, it is an orverlapping
                if (end > midInterval[0]) {
                    return false;
                }
                right = mid - 1;
            }
        }
        intervals.add(left, new int[]{start, end});
        return true;
    }

}
