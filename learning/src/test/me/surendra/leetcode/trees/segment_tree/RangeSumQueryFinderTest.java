package me.surendra.leetcode.trees.segment_tree;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RangeSumQueryFinderTest {

    @Test
    public void test1() {
        final RangeSumQueryFinder rangeSumQueryFinder = new RangeSumQueryFinder(new int[]{1, 3, 5});

        assertThat(rangeSumQueryFinder.sumRange(0, 2), equalTo(9));
//        assertThat(rangeSumQueryFinder.sumRange(1, 2), equalTo(8));

//        rangeSumQueryFinder.update(1, 2);
//        assertThat(rangeSumQueryFinder.sumRange(0, 2), equalTo(8));
    }


    @Test
    public void test2() {
        final RangeSumQueryFinder rangeSumQueryFinder = new RangeSumQueryFinder(new int[]{1, 2, 3, 4});

        assertThat(rangeSumQueryFinder.sumRange(0, 3), equalTo(10));
//        assertThat(rangeSumQueryFinder.sumRange(1, 3), equalTo(9));
    }


    @Test
    public void test3() {
        final RangeSumQueryFinder rangeSumQueryFinder = new RangeSumQueryFinder(new int[]{1, 2, 3, 4, 5, 6});

        assertThat(rangeSumQueryFinder.sumRange(0, 4), equalTo(15));
        assertThat(rangeSumQueryFinder.sumRange(0, 5), equalTo(21));

        rangeSumQueryFinder.update(5, 5);
        assertThat(rangeSumQueryFinder.sumRange(0, 5), equalTo(20));
    }

}
