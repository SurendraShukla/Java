package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StockProfitBookerIITest {

    private int callMethod(final int[] prices) {
        return new StockProfitBookerII().maxProfit(prices);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{7,1,5,3,6,4}), equalTo(7));
        assertThat(callMethod(new int[]{1,2,3,4,5}), equalTo(4));
        assertThat(callMethod(new int[]{7,6,4,3,1}), equalTo(0));
    }

}
