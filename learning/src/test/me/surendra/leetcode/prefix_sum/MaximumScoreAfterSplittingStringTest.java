package me.surendra.leetcode.prefix_sum;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MaximumScoreAfterSplittingStringTest {

    private final MaximumScoreAfterSplittingString maximumScoreAfterSplittingString = new MaximumScoreAfterSplittingString();

    private int callMethod(final String number) {
        return maximumScoreAfterSplittingString.maxScore(number);
//        return maximumScoreAfterSplittingString.maxScoreUsingPrefixSum(number);
    }

    @Test
    public void test() {
        assertThat(callMethod("011101"), equalTo(5));
        assertThat(callMethod("00111"), equalTo(5));
        assertThat(callMethod("1111"), equalTo(3));
    }

}
