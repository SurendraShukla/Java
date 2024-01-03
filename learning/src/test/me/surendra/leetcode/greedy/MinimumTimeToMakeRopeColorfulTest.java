package me.surendra.leetcode.greedy;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinimumTimeToMakeRopeColorfulTest {

    private final MinimumTimeToMakeRopeColorful minimumTimeToMakeRopeColorful = new MinimumTimeToMakeRopeColorful();

    private int callMethod(final String abaac, final int[] neededTime) {
        return minimumTimeToMakeRopeColorful.minCost(abaac, neededTime);
//        return minimumTimeToMakeRopeColorful.minCost2Pointers(abaac, neededTime);
    }

    @Test
    public void test() {
        assertThat(
            callMethod("abaac", new int[]{1, 2, 3, 4, 5}),
            equalTo(3)
        );

        assertThat(
            callMethod("abc", new int[]{1, 2, 3}),
            equalTo(0)
        );

        assertThat(
            callMethod("aabaa", new int[]{1, 2, 3, 4, 1}),
            equalTo(2)
        );
    }

}
