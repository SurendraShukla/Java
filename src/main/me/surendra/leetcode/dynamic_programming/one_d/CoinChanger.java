package me.surendra.leetcode.dynamic_programming.one_d;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 */
public class CoinChanger {

    /*
        Time Complexity - O(s * n), where S is amount and n is no. of coins
        Space Complexity - O(s), S is the amount to change We use extra space for the memoization table
     */
    public int coinChange(final int[] coins, final int amount) {
        final int[] cache = new int[amount + 1];
        return coinChange(coins, amount, cache);
    }

    public int coinChange(final int[] coins, final int amount, final int[] cache) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (cache[amount] != 0) {
            return cache[amount];
        }

        int coinsNeeded = Integer.MAX_VALUE;
        for (int coin: coins) {
            final int tmpCoinCount = coinChange(coins, amount - coin, cache);
            if (tmpCoinCount >= 0) {
                coinsNeeded = Math.min(coinsNeeded, tmpCoinCount + 1);
            }
        }

        cache[amount] = coinsNeeded == Integer.MAX_VALUE ? -1 : coinsNeeded;
        return cache[amount];
    }


    /*
        Time Complexity - O(s * n), where S is amount and n is no. of coins
        Space Complexity - O(s), S is the amount to change We use extra space for the memoization table
     */
    public int coinChangeUsingDynamicProgramming(final int[] coins, final int amount) {
        final int max = amount + 1;
        final int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (final int coin : coins) {
                final int tmpAmount = i;
                if (coin <= tmpAmount) {
                    dp[i] = Math.min(dp[tmpAmount], dp[tmpAmount - coin] + 1);
                }
            }
        }

        return (dp[amount] > max) ? -1 : dp[amount];
    }

}
