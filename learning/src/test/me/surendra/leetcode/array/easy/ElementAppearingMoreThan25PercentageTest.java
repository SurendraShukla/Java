package me.surendra.leetcode.array.easy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ElementAppearingMoreThan25PercentageTest {

    private final ElementAppearingMoreThan25Percentage elementAppearingMoreThan25Percentage = new ElementAppearingMoreThan25Percentage();

    private int callMethod(final int[] arr) {
        return elementAppearingMoreThan25Percentage.findSpecialInteger(arr);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}),
            equalTo(6)
        );

        assertThat(
            callMethod(new int[]{1, 1}),
            equalTo(1)
        );
    }

}
