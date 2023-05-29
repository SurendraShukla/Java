package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LastStoneWeigherTest {

    private int callMethod(final int[] stones) {
        return new LastStoneWeigher().lastStoneWeight(stones);
    }

    @Test
    public void test1() {
        final int[] stones = {2,7,4,1,8,1};

        assertThat(callMethod(stones), equalTo(1));
    }

    @Test
    public void test2() {
        final int[] stones = {1};

        assertThat(callMethod(stones), equalTo(1));
    }

    @Test
    public void test3() {
        final int[] stones = {2,2};

        assertThat(callMethod(stones), equalTo(0));
    }
}
