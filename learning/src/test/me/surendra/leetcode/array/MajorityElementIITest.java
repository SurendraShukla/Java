package me.surendra.leetcode.array;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MajorityElementIITest {

    private final MajorityElementII majorityElementII = new MajorityElementII();

    private List<Integer> callMethod(final int[] nums) {
        return majorityElementII.majorityElement(nums);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new int[]{3, 2, 3}),
            equalTo(Arrays.asList(3))
        );

        assertThat(
            callMethod(new int[]{1}),
            equalTo(Arrays.asList(1))
        );

        assertThat(
            callMethod(new int[]{1, 2}),
            equalTo(Arrays.asList(1, 2))
        );
    }

}
