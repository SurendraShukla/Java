package me.surendra.leetcode.array.hard;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/"></a>
 */
public class ContainerWithMostWater {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxAreaUsing2Pointers(int[] height) {
        int maxArea = 0, leftPointer = 0, rightPointer = height.length-1;
        while(leftPointer < rightPointer) {
            final int containerWidth = rightPointer - leftPointer;
            final int containerHeight = Math.min(height[leftPointer], height[rightPointer]);
            final int currentArea = containerHeight * containerWidth;
            maxArea = Math.max(currentArea, maxArea);
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return maxArea;
    }
    /*
        Time complexity: O(n^2)
        Space complexity: O(1)
     */
    public int maxAreaUsingBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int containerWidth = j - i;
                int containerHeight = Math.min(height[i], height[j]);
                int currentArea = containerHeight*containerWidth;
                maxArea = Math.max(currentArea, maxArea);
            }
        }
        return maxArea;
    }

}
