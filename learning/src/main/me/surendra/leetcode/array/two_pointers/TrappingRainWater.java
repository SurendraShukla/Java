package me.surendra.leetcode.array.two_pointers;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">Trapping Rain Water</a>
 */
public class TrappingRainWater {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int trapUsing2Arrays(final int[] height) {
        final int[] left = new int[height.length];
        final int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            right[j] = Math.max(height[j], right[j + 1]);
        }

        int maxWater = 0;
        for (int k = 1; k < height.length - 1; k++) {
            final int minHeight = Math.min(left[k], right[k]);
            final int curHeight = height[k];
            if (minHeight > curHeight) {
                maxWater += minHeight - curHeight;
            }
        }

        return maxWater;
    }

}
