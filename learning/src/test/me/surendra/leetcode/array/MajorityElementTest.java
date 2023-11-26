package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MajorityElementTest {

    private final MajorityElement majorityElement = new MajorityElement();

    private int callMethod(final int[] nums) {
//        return new MajorityElement().majorityElementUsingArraySort(nums);
        return majorityElement.majorityElementUsingBoyerMooreVotingAlgorithm(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{3, 2, 3}),  equalTo(3));
        assertThat(callMethod(new int[]{3, 3, 4}),  equalTo(3));
        assertThat(callMethod(new int[]{1, 2, 3, 3, 2, 2, 2}),  equalTo(2));
        assertThat(callMethod(new int[]{2, 2, 1, 1, 1, 2, 2}),  equalTo(2));
        assertThat(callMethod(new int[]{10, 9, 9, 9, 10}),  equalTo(9));
    }

}
