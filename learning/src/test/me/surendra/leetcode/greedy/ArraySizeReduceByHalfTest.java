package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ArraySizeReduceByHalfTest {

    private int calMethod(final int[] arr) {
        return new ArraySizeReduceByHalf().minSetSize(arr);
    }

    @Test
    public void test() {
        assertThat(calMethod(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}), equalTo(2));
        assertThat(calMethod(new int[]{7, 7, 7, 7, 7, 7}), equalTo(1));
    }

}
