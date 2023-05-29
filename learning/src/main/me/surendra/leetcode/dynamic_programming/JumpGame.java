package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 */
public class JumpGame {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public static boolean canJumpReverseDirection(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }

}
