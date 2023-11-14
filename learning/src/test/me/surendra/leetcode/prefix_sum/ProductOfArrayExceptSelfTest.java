package me.surendra.leetcode.prefix_sum;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProductOfArrayExceptSelfTest {

    private final ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

    int[] callMethod(final int[] nums) {
        return productOfArrayExceptSelf.productExceptSelf(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{1, 2, 3, 4}), equalTo(new int[]{24, 12, 8, 6}));
        assertThat(callMethod(new int[]{-1, 1, 0, -3, 3}), equalTo(new int[]{0, 0, 9, 0, 0}));
    }

}
