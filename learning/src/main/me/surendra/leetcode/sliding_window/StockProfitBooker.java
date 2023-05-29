package me.surendra.leetcode.sliding_window;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a>
 */
public class StockProfitBooker {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxProfit(final int[] prices) {
        final int length = prices.length;
        int maxProfit = 0;
        int minVal = prices[0];
        for (int i = 1; i < length; i++) {
            minVal = Math.min(prices[i], minVal);
            maxProfit = Math.max(prices[i] - minVal, maxProfit);
        }
        return maxProfit;
    }

}
