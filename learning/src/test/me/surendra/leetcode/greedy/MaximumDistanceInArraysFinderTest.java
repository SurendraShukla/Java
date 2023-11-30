package me.surendra.leetcode.greedy;


import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumDistanceInArraysFinderTest {

    private final MaximumDistanceInArraysFinder maximumDistanceInArraysFinder = new MaximumDistanceInArraysFinder();

    private int callMethod(final List<List<Integer>> arrays) {
        return maximumDistanceInArraysFinder.maxDistance(arrays);
    }

    @Test
    public void test1() {
        final List<List<Integer>> arrays = Lists.newArrayList(
            Lists.newArrayList(1, 2, 3),
            Lists.newArrayList(4, 5),
            Lists.newArrayList(1, 2, 3)
        );

        assertThat(callMethod(arrays), equalTo(4));
    }


    @Test
    public void test2() {
        final List<List<Integer>> arrays = Lists.newArrayList(
            Lists.newArrayList(1),
            Lists.newArrayList(1)
        );

        assertThat(callMethod(arrays), equalTo(0));
    }


    @Test
    public void test3() {
        final List<List<Integer>> arrays = Lists.newArrayList(
            Lists.newArrayList(-1, 1),
            Lists.newArrayList(-3, 1, 4),
            Lists.newArrayList(-2, -1, 0, 2)
        );

        assertThat(callMethod(arrays), equalTo(6));
    }

}
