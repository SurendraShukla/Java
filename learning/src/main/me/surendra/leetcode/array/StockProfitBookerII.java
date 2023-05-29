package me.surendra.leetcode.array;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II</a>
 */
public class StockProfitBookerII {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxProfit(final int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit+= prices[i] - prices[i-1];
            }
        }
        return profit;
    }

}
