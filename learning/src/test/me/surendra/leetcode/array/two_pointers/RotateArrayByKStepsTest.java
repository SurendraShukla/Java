package me.surendra.leetcode.array.two_pointers;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class RotateArrayByKStepsTest extends TestCase {

    private void callMethod(final int[] nums, final int k) {
        new RotateArrayByKSteps().rotateByReversingIn3Steps(nums, k);
    }

    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        int[] expected = {5,6,7,1,2,3,4};

        callMethod(nums, 3);

        assertThat(nums, equalTo(expected));
    }

}
