package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class JumpGameTest {

    private boolean callMethod(final int[] nums) {
        return JumpGame.canJumpReverseDirection(nums);
    }

    @Test
    public void canJump() {
        assertThat(callMethod(new int[]{0}), equalTo(true));
        assertThat(callMethod(new int[]{2,0,0}), equalTo(true));
        assertThat(callMethod(new int[]{2,3,1,1,4}), equalTo(true));
        assertThat(callMethod(new int[]{2,4,1,1,4}), equalTo(true));
        assertThat(callMethod(new int[]{3,2,2,0,4}), equalTo(true));
        assertThat(callMethod(new int[]{3,0,8,2,0,0,1}), equalTo(true));
    }

    @Test
    public void canNotJump() {
        assertThat(callMethod(new int[]{0,2,3}), equalTo(false));
        assertThat(callMethod(new int[]{1,0,1,0}), equalTo(false));
        assertThat(callMethod(new int[]{3,2,1,0,4}), equalTo(false));
    }

}
