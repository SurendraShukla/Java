package me.surendra.leetcode.binary_search;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MajorityElementSearchInASortedArrayTest {

    final MajorityElementSearchInASortedArray majorityElementSearchInASortedArray = new MajorityElementSearchInASortedArray();

    private boolean callMethod(final int[] nums, final int target) {
        return majorityElementSearchInASortedArray.isMajorityElement(nums, target);
    }

    @Test
    public void name() {
        assertThat(callMethod(new int[]{1}, 1), equalTo(true));
        assertThat(callMethod(new int[]{1, 2, 2}, 2), equalTo(true));
        assertThat(callMethod(new int[]{438885258, 438885258}, 438885258), equalTo(true));
        assertThat(callMethod(new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6}, 5), equalTo(true));

        assertThat(callMethod(new int[]{1}, 2), equalTo(false));
        assertThat(callMethod(new int[]{1, 2, 3, 4, 5}, 3), equalTo(false));
        assertThat(callMethod(new int[]{10, 100, 101, 101}, 101), equalTo(false));
    }

}
