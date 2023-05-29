package me.surendra.leetcode.heap;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KthLargestElementInAStreamTest {
    final KthLargestElementInAStream kthLargestElementInAStream = new KthLargestElementInAStream();

    @Test
    public void testBuildUsingPriorityQueue() {
        final int[] nums = {4, 5, 8, 2};
        final KthLargestElementInAStream unit = kthLargestElementInAStream.buildUsingPriorityQueue(3, nums);

        assertThat(unit.addToPriorityQueue(3), equalTo(4));
        assertThat(unit.addToPriorityQueue(5), equalTo(5));
        assertThat(unit.addToPriorityQueue(10), equalTo(5));
        assertThat(unit.addToPriorityQueue(9), equalTo(8));
        assertThat(unit.addToPriorityQueue(4), equalTo(8));
    }

    @Test
    public void testBuildUsingBinarySearch() {
        final int[] nums = {4, 5, 8, 2};
        final KthLargestElementInAStream unit = kthLargestElementInAStream.buildUsingBinarySearchList(3, nums);

        assertThat(unit.addToList(3), equalTo(4));
        assertThat(unit.addToList(5), equalTo(5));
        assertThat(unit.addToList(10), equalTo(5));
        assertThat(unit.addToList(9), equalTo(8));
        assertThat(unit.addToList(4), equalTo(8));
    }
}
