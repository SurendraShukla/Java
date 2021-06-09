package me.surendra.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class StockSpannerTest {

    private StockSpanner stockSpanner;

    @Before
    public void setUp() throws Exception {
        stockSpanner = new StockSpanner();
    }


    private void callMethodAndAssert(final int[] input, final int[] output) {
        for (int i = 0; i < input.length; i++) {
            assertThat(stockSpanner.next(input[i]), equalTo(output[i]));
        }
    }

    @Test
    public void test() {
        final int[] input = {100, 80, 60, 70, 60, 75, 85};
        final int[] output = {1, 1, 1, 2, 1, 4, 6};

        callMethodAndAssert(input, output);
    }

}
