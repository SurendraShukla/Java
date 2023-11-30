package me.surendra.leetcode.sliding_window;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MaxConsecutiveOnesIITest {

    private final MaxConsecutiveOnesII maxConsecutiveOnesII = new MaxConsecutiveOnesII();

    private int callMethod(final int[] nums) {
        return maxConsecutiveOnesII.findMaxConsecutiveOnes(nums);
//        return maxConsecutiveOnesII.findMaxConsecutiveOnesWith2Variables(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{1, 0, 1, 1, 0}), equalTo(4));
        assertThat(callMethod(new int[]{1, 0, 1, 1, 0, 1}), equalTo(4));
        assertThat(callMethod(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1}), equalTo(8));

        assertThat(
            callMethod(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
            equalTo(40)
        );
    }

}
