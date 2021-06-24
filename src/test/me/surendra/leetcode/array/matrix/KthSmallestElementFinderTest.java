package me.surendra.leetcode.array.matrix;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KthSmallestElementFinderTest {

    private int callMethod(final int[][] input, final int k) {
        return new KthSmallestElementFinder().kthSmallestInSortedArray(input, k);
    }

    @Test
    public void test1() {
        final int[][] input = {{-5}};
        assertThat(callMethod(input, 1), equalTo(-5));
    }

    @Test
    public void test2() {
        final int[][] input = {{1,2},{1,3}};

        assertThat(callMethod(input, 2), equalTo(1));
    }

    @Test
    public void test3() {
        final int[][] input = {{1,5,9},{10,11,13},{12,13,15}};

        assertThat(callMethod(input, 8), equalTo(13));
    }

}
