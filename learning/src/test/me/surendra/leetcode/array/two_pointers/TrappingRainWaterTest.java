package me.surendra.leetcode.array.two_pointers;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TrappingRainWaterTest {

    private final TrappingRainWater trappingRainWater = new TrappingRainWater();

    private int callMethod(final int[] height) {
        return trappingRainWater.trapUsing2Arrays(height);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}),
            equalTo(6)
        );

        assertThat(
            callMethod(new int[]{4, 2, 0, 3, 2, 5}),
            equalTo(9)
        );
    }

}
