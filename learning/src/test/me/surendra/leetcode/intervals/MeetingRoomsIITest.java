package me.surendra.leetcode.intervals;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MeetingRoomsIITest {

    private final MeetingRoomsII meetingRoomsII = new MeetingRoomsII();

    private int callMethod(final int[][] intervals) {
        return meetingRoomsII.minMeetingRoomsUsingMinHeap(intervals);
//        return meetingRoomsII.minMeetingRoomsUsingArray(intervals);
    }

    @Test
    public void test1() {
//        System.out.println(Character.getNumericValue(-1));
//        final int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
//
//        assertThat(callMethod(intervals), equalTo(2));
    }


    @Test
    public void test2() {
        final int[][] intervals = {{7, 10}, {2, 4}};

        assertThat(callMethod(intervals), equalTo(1));
    }

}
