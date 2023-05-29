package me.surendra.leetcode.intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindFreeTimeForMeetupTest {

    @Test
    public void findFreeTimesForOnePerson() {
        final List<List<Integer[]>> input = new ArrayList<>();
        final List<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[]{1, 2});
        intervals.add(new Integer[]{4, 5});
        intervals.add(new Integer[]{3, 4});
        intervals.add(new Integer[]{9, 10});
        input.add(intervals);

        new FindFreeTimeForMeetup().findFreeTimes(input);
    }


    @Test
    public void findFreeTimesForOtherPerson() {
        final List<List<Integer[]>> input = new ArrayList<>();
        final List<Integer[]> intervals = new ArrayList<>();
        intervals.add(new Integer[]{0, 2});
        intervals.add(new Integer[]{4, 5});
        intervals.add(new Integer[]{3, 4});
        intervals.add(new Integer[]{9, 10});
        intervals.add(new Integer[]{16, 23});
        input.add(intervals);

        new FindFreeTimeForMeetup().findFreeTimes(input);
    }
}
