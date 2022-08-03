package me.surendra.leetcode.intervals;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MyCalendarITest {

    private final MyCalendarI myCalendarI = new MyCalendarI();

    public boolean callMethod(final int start, final int end) {
        return myCalendarI.bookUsingTreeSet(start, end);
//        return myCalendarI.bookUsingBinarySearch(start, end);
    }

    @Test
    public void test() {
        assertThat(callMethod(10, 20), equalTo(true));
        assertThat(callMethod(15, 25), equalTo(false));
        assertThat(callMethod(20, 30), equalTo(true));
        assertThat(callMethod(30, 31), equalTo(true));
    }

}
