package me.surendra.leetcode.intervals;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PersonCanAttendAllMeetingTest {

    private boolean callMethod(final int[][] intervals) {
        return new PersonCanAttendAllMeeting().canAttendMeetings(intervals);
//        return new PersonCanAttendAllMeeting().canAttendMeetingsByCheckingMeetingStartIsNotInBetweenFirstMeetingTime(intervals);
    }

    @Test
    public void canAttendAllMeetings() {
        int[][] intervals = {{7,10},{2,4}};

        assertThat(callMethod(intervals), equalTo(true));
    }

    @Test
    public void canAttendAllMeetingsEvenIf2MeetingsStartIs1stMeetingsEndInterval() {
        int[][] intervals = {{13,15},{1,13}};

        assertThat(callMethod(intervals), equalTo(true));
    }

    @Test
    public void canNotAttendAllMeetings() {
        int[][] intervals = {{0,30},{5,10},{15,20}};

        assertThat(callMethod(intervals), equalTo(false));
    }


}
