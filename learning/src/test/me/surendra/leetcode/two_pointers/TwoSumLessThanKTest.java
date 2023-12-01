package me.surendra.leetcode.two_pointers;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TwoSumLessThanKTest {

    private final TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();

    private int callMethod(final int[] nums, final int k) {
        return twoSumLessThanK.twoSumLessThanK2Pointers(nums, k);
//        return twoSumLessThanK.twoSumLessThanKBruteForce(nums, k);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60),
            equalTo(58)
        );

        assertThat(
            callMethod(new int[]{10, 20, 30}, 15),
            equalTo(-1)
        );
    }

}
