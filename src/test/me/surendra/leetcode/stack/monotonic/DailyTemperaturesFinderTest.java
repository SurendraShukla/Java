package me.surendra.leetcode.stack.monotonic;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DailyTemperaturesFinderTest {

    private int[] callMethod(final int[] temperatures) {
        return new DailyTemperaturesFinder().dailyTemperatures(temperatures);
    }

    @Test
    public void mix() {
        final int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        final int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        assertThat(callMethod(temperatures), equalTo(expected));
    }

    @Test
    public void increasing() {
        final int[] temperatures = {30, 40, 50, 60};
        final int[] expected = {1, 1, 1, 0};

        assertThat(callMethod(temperatures), equalTo(expected));
    }

    @Test
    public void increasingInDouble() {
        final int[] temperatures = {30, 60, 90};
        final int[] expected = {1, 1, 0};

        assertThat(callMethod(temperatures), equalTo(expected));
    }

    @Test
    public void same() {
        final int[] temperatures = {30, 30, 30};
        final int[] expected = {0, 0, 0};

        assertThat(callMethod(temperatures), equalTo(expected));
    }

}
