package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class UniquePathsFinderTest {

    private long callMethod(final int m, final int n) {
        return new UniquePathsFinder().uniquePaths(m, n);
    }

    @Test
    public void someInputs() {
        assertThat(callMethod(1, 2), equalTo(1L));
        assertThat(callMethod(2, 1), equalTo(1L));
        assertThat(callMethod(1, 3), equalTo(1L));
        assertThat(callMethod(3, 1), equalTo(1L));
    }

    @Test
    public void inputMinLimit() {
        assertThat(callMethod(1, 1), equalTo(1L));
    }

    @Test
    public void inputMaxLimit() {
        assertThat(callMethod(100, 100), equalTo(4631081169483718960L));
    }

}
