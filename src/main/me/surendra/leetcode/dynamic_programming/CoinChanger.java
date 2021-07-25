package me.surendra.leetcode.dynamic_programming;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 */
public class CoinChanger {

    /*
        Time Complexity - O(s * n), where S is amount and n is no. of coins
        Space Complexity - O(s), S is the amount to change We use extra space for the memoization table
     */
    public int coinChangeUsingRecursionWithMemoization(int[] coins, int amount) {
        return coinChangeHelper(coins, amount, new int[amount+1]);
    }

    public int coinChangeHelper(int[] coins, int amount, int[] memoizationTable) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memoizationTable[amount] != 0) {
            return memoizationTable[amount];
        }
        int max = amount + 1;
        int minCoins = max;
        for (final int coin : coins) {
            int totalCoins = coinChangeHelper(coins, amount - coin, memoizationTable);
            if (totalCoins == -1) {
                continue;
            }
            minCoins = Math.min(totalCoins + 1, minCoins);
        }
        memoizationTable[amount] = (minCoins == max) ? -1 : minCoins;
        return memoizationTable[amount];
    }


    /*
        Time Complexity - O(s ^ n), where S is amount and n is no. of coins
        Space Complexity - O(n), function is recursively called for amount (n)
     */
    public int coinChangeUsingRecursion(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int max = amount + 1;
        int minCoins = max;
        for (final int coin : coins) {
            int totalCoins = coinChangeUsingRecursion(coins, amount - coin);
            if (totalCoins == -1) {
                continue;
            }
            minCoins = Math.min(totalCoins + 1, minCoins);
        }
        return (minCoins == max) ? -1 : minCoins;
    }


    /*
        Time Complexity - O(s * n), where S is amount and n is no. of coins
        Space Complexity - O(s), S is the amount to change We use extra space for the memoization table
     */
    public int coinChangeUsingDynamicProgramming(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i=1; i<=amount; i++) {
            for (final int coin : coins) {
                int tmpAmount = i;
                if (coin <= tmpAmount) {
                    dp[i] = Math.min(dp[tmpAmount], dp[tmpAmount - coin] + 1);
                }
            }
        }

        return (dp[amount] > max) ? -1 : dp[amount];

    }

}
