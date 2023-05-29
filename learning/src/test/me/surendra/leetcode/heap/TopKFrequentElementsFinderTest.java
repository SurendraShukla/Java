package me.surendra.leetcode.heap;

import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TopKFrequentElementsFinderTest {

    private final TopKFrequentElementsFinder topKFrequentElementsFinder = new TopKFrequentElementsFinder();

    private int[] callMethod(final int[] nums, final int k) {
        return topKFrequentElementsFinder.topKFrequentUsingHeapReferringMap(nums, k);
//        return topKFrequentElementsFinder.topKFrequentUsingHeap(nums, k);
//        return topKFrequentElementsFinder.topKFrequentUsingSorting(nums, k);
    }

    @Test
    public void test1() {
        final int[] nums = {1, 1, 1, 2, 2, 3};

        final int[] expected = {1, 2};
        assertThat(callMethod(nums, 2), equalTo(expected));
    }

    @Test
    public void test2() {
        final int[] nums = {1};

        final int[] expected = {1};
        assertThat(callMethod(nums, 1), equalTo(expected));
    }

}
