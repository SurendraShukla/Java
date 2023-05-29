package me.surendra.leetcode.intervals;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
 */
public class MeetingRoomsII {


    /*
        Time Complexity - O(n log n)
        Space Complexity - 0(n)
     */
    public int minMeetingRoomsUsingMinHeap(final int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        final PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] interval: intervals) {
            if (q.isEmpty()) {
                q.add(interval[1]);
                continue;
            }
            final int endTime = q.peek();
            if (interval[0] >= endTime) {
                q.remove();
            }
            q.add(interval[1]);
        }
        return q.size();
    }


    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public int minMeetingRoomsUsingArray(final int[][] intervals) {
        final int[] meetingRoomsNeeded = new int[1000001];
        for (int[] interval : intervals) {
            for (int i = interval[0]; i < interval[1]; i++) {
                meetingRoomsNeeded[i] = meetingRoomsNeeded[i] + 1;
            }
        }
        int maxMeetingRooms = 0;
        for (int meetingRooms: meetingRoomsNeeded) {
            maxMeetingRooms = Math.max(meetingRooms, maxMeetingRooms);
        }
        return maxMeetingRooms;
    }

}

