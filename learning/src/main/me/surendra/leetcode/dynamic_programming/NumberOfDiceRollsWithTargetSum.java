package me.surendra.leetcode.dynamic_programming;


/**
 * @see <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">Number of Dice Rolls With Target Sum</a>
 */
public class NumberOfDiceRollsWithTargetSum {

    /*
        Time Complexity - O(n * t * k) N is the number of dice, K is the number of faces each dice have, and T is the target value
        Space Complexity - O(n * t)
     */
    int diceFaces;
    Integer[][] cache;
    public int numRollsToTarget(final int n, final int k, final int target) {
        diceFaces = k;
        cache = new Integer[n + 1][target + 1];

        return numRollsToTarget(n, target);
    }

    private int numRollsToTarget(final int n, final int target) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n <= 0 || target <= 0) {
            return 0;
        }
        if (cache[n][target] != null) {
            return cache[n][target];
        }
        int result = 0;
        for (int diceFace = 1; diceFace <= diceFaces; diceFace++) {
            result = (result + numRollsToTarget(n - 1, target - diceFace)) % 1_000_000_007;
        }

        cache[n][target] = result;
        return result;
    }

}
