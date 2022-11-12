package me.surendra.leetcode.array.two_pointers;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/"></a>
 */
public class ContainerWithMostWater {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxAreaUsing2Pointers(final int[] height) {
        int mostCollectedWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            final int w = right - left;
            final int h = Math.min(height[left], height[right]);
            mostCollectedWater = Math.max(mostCollectedWater, w * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return mostCollectedWater;
    }


    /*
        Time complexity: O(n^2)
        Space complexity: O(1)
     */
    public int maxAreaUsingBruteForce(final int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                final int containerWidth = j - i;
                final int containerHeight = Math.min(height[i], height[j]);
                final int currentArea = containerHeight * containerWidth;
                maxArea = Math.max(currentArea, maxArea);
            }
        }
        return maxArea;
    }

}
