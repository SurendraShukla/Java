package me.surendra.leetcode.search.binary_search;

import me.surendra.leetcode.search.binary_search.PeakElementFinder;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PeakElementFinderTest {

    private int callMethod(final int[] nums) {
        return new PeakElementFinder().findPeakElementUsingBinarySearch(nums);
//        return new PeakElementFinder().findPeakElementByComparingNextValueOnly(nums);
//        return new PeakElementFinder().findPeakElementByBothSideValues(nums);
    }

    @Test
    public void noPeakElement() {
        assertThat(callMethod(new int[]{1}), equalTo(0));
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{1,2,3,1}), equalTo(2));
        assertThat(callMethod(new int[]{1,2,3,4}), equalTo(3));
        assertThat(callMethod(new int[]{4,3,2,1}), equalTo(0));
        assertThat(callMethod(new int[]{2,3,2,1}), equalTo(1));
    }

    @Test
    public void test2() {
        int[] nums = {1,2,1,3,5,6,4};

        assertThat(callMethod(nums), equalTo(1));
//        assertThat(callMethod(nums), equalTo(5));
    }

}
