package me.surendra.leetcode.array;

/**
 * @see <a href="https://leetcode.com/problems/moving-average-from-data-stream/">Moving Average from Data Stream</a>
 */
public class MovingAverage {

    int[] arr;
    int size;
    int total = 0;
    int idx = 0;
    public MovingAverage(final int size) {
        this.size = size;
        arr = new int[size];
    }

    public double next(final int val) {
        final int indexToOverride = idx %  size;
        total = total - arr[indexToOverride] + val;
        arr[indexToOverride] = val;
        idx++;

        if (idx < size) {
            return (double)total / idx;
        }
        return (double)total / size;
    }

}
