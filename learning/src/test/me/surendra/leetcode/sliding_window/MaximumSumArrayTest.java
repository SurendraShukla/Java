package me.surendra.leetcode.sliding_window;


import me.surendra.leetcode.sliding_window.MaximumSumArray;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MaximumSumArrayTest {

    @Test
    public void test1() {
        final int[] input = {2, 1, 5, 1, 3, 2};

        assertThat(MaximumSumArray.getMaximumSumArray(input, 3) , equalTo(9));
    }

    @Test
    public void test2() {
        final int[] input = {2, 3, 4, 1, 5};

        assertThat(MaximumSumArray.getMaximumSumArray(input, 2) , equalTo(7));
    }
}
