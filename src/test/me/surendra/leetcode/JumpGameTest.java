package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class JumpGameTest {

    @Test
    public void canJump() {
        assertThat(JumpGame.canJump(new int[]{0}), equalTo(true));
        assertThat(JumpGame.canJump(new int[]{2,0,0}), equalTo(true));
        assertThat(JumpGame.canJump(new int[]{2,3,1,1,4}), equalTo(true));
        assertThat(JumpGame.canJump(new int[]{2,4,1,1,4}), equalTo(true));
        assertThat(JumpGame.canJump(new int[]{3,2,2,0,4}), equalTo(true));
        assertThat(JumpGame.canJump(new int[]{3,0,8,2,0,0,1}), equalTo(true));
    }

    @Test
    public void canNotJump() {
        assertThat(JumpGame.canJump(new int[]{0,2,3}), equalTo(false));
        assertThat(JumpGame.canJump(new int[]{1,0,1,0}), equalTo(false));
        assertThat(JumpGame.canJump(new int[]{3,2,1,0,4}), equalTo(false));
    }

}
