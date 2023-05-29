package me.surendra.leetcode.array;

import java.util.Random;

public class ShuffleAnArray {

    private int[] nums;
    private int[] originalNums;

    public ShuffleAnArray(int[] nums) {
        nums = nums;
        originalNums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = originalNums;
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        final int randomIndex = getRandomNumberUsingNextInt(nums.length - 1);
        return nums;
    }

    public int getRandomNumberUsingNextInt(int max) {
        return new Random().nextInt(max - 0) + 0;
    }

}
