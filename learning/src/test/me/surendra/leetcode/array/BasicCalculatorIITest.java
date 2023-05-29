package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BasicCalculatorIITest {

    private int callMethod(final String s) {
        return new BasicCalculatorII().calculate(s);
    }

    @Test
    public void addition() {
        assertThat(callMethod("3+2*2"), equalTo(7));
    }

}
