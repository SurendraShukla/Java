package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class StringAdderTest {

    private String callMethod(final String num1, final String num2) {
        return new StringAdder().addStrings(num1, num2);
//        return new StringAdder().addStringsUsingStack(num1, num2);
    }

    @Test
    public void test() {
        assertThat(callMethod("11", "123"), equalTo("134"));
        assertThat(callMethod("456", "77"), equalTo("533"));
        assertThat(callMethod("0", "0"), equalTo("0"));
    }

    @Test
    public void carryForward() {
        assertThat(callMethod("1", "9"), equalTo("10"));
    }

}
