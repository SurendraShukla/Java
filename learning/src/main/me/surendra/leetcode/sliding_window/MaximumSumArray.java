package me.surendra.leetcode.sliding_window;

public class MaximumSumArray {

    public static int getMaximumSumArray(final int[] arr, final int k) {
        int maximumSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (i >= k - 1) {
                maximumSum = Math.max(maximumSum, currentSum);
                currentSum -= arr[(i + 1) - k];
            }
        }
        return maximumSum;
    }

}
