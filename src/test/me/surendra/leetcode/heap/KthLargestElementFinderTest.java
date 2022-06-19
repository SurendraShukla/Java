package me.surendra.leetcode.heap;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class KthLargestElementFinderTest {

    private int callMethod(final int[] nums, final int k) {
        return new KthLargestElementFinder().findKthLargestUsingHeap(nums, k);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{3,3,2,1}, 2), equalTo(3));
//        assertThat(callMethod(new int[]{3,2,1,5,6,4}, 2), equalTo(5));
//        assertThat(callMethod(new int[]{3,2,3,1,2,4,5,5,6}, 4), equalTo(4));
    }

}
