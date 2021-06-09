package me.surendra.leetcode;

import java.util.ArrayList;

/**
 * @see <a href="https://leetcode.com/problems/online-stock-span/">Online Stock Span</a>
 */
public class StockSpanner {
    private final ArrayList<Integer> stockPrice;
    private int index;

    public StockSpanner() {
        stockPrice = new ArrayList<>();
        index = 0;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int next(final int price) {
        int noOfDays = 1;
        int tmpIndex = index-1;
        while(tmpIndex>=0 && stockPrice.get(tmpIndex)<=price) {
            tmpIndex--;
            noOfDays++;
        }
        stockPrice.add(index++, price);
        return noOfDays;
    }
}
