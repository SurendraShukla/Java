package me.surendra.leetcode.set;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestConsecutiveSequenceTest {

    private final LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

    private int callMethod(final int[] nums) {
        return longestConsecutiveSequence.longestConsecutive(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{6, 5, 4, 3, 2, 1}), equalTo(6));
        assertThat(callMethod(new int[]{100, 4, 200, 1, 3, 2}), equalTo(4));
        assertThat(callMethod(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}), equalTo(9));
    }

}
