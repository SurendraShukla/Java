package me.surendra.leetcode.greedy;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LargestNumberFinderTest {

    private String callMethod(final int[] nums) {
        return new LargestNumberFinder().largestNumber(nums);
    }

    @Test
    public void test1() {
//        assertThat(callMethod(new int[]{10,2}), equalTo("210"));
//        assertThat(callMethod(new int[]{3,30,34,5,9}), equalTo("2953433010"));
//        assertThat(callMethod(new int[]{9, 98}), equalTo("998"));
        assertThat(callMethod(new int[]{8, 89}), equalTo("898"));
//        assertThat(callMethod(new int[]{8, 87}), equalTo("887"));
    }



}
