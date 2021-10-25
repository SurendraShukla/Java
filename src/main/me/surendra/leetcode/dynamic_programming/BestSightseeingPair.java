package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/best-sightseeing-pair/">Best Sightseeing Pair</a>
 */
public class BestSightseeingPair {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxScoreSightSeeingPair(int[] values) {
        int firstPairMax = values[0];
        int maximumScore = 0;
        for (int i = 1; i < values.length; i++) {
            firstPairMax = Math.max(firstPairMax, values[i-1] + i-1);
            maximumScore = Math.max(maximumScore, firstPairMax + values[i] - i);
        }
        return maximumScore;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxScoreSightSeeingPairUsing2Iteration(int[] values) {
        int length = values.length;
        int[] firstPair = new int[length];
        firstPair[0] = values[0];
        int firstPairMax = values[0];
        for (int i = 1; i < length; i++) {
            firstPairMax = Math.max(firstPairMax, values[i] + i);
            firstPair[i] = firstPairMax;
        }

        int maximumScore = 0;
        for (int j = 1; j < length; j++) {
            maximumScore = Math.max(maximumScore, firstPair[j-1] + values[j] - j);
        }
        return maximumScore;
    }

}
