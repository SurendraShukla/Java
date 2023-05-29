package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class JumpGameIITest {

    private final JumpGameII jumpGameII = new JumpGameII();

    private int callMethod(final int[] nums) {
        return jumpGameII.jumpUsingRecursion(nums);
//        return jumpGameII.jump(nums);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[]{0}), equalTo(0));
        assertThat(callMethod(new int[]{2, 1}), equalTo(1));

        assertThat(callMethod(new int[]{3, 2, 1}), equalTo(1));
        assertThat(callMethod(new int[]{1, 2, 3}), equalTo(2));

        assertThat(callMethod(new int[]{2, 3, 1, 1, 4}), equalTo(2));

        assertThat(callMethod(new int[]{2, 3, 0, 1, 4}), equalTo(2));
    }

}
