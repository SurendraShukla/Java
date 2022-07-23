package me.surendra.leetcode.stack;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class EvaluateReversePolishNotationTest {

    private EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();

    private int callMethod(final String[] tokens) {
        return evaluateReversePolishNotation.evalRPN(tokens);
//        return evaluateReversePolishNotation.evalRPNUsingHashMap(tokens);
    }

    @Test
    public void test() {
        assertThat(callMethod(new String[]{"5", "3", "+"}), equalTo(8));
        assertThat(callMethod(new String[]{"2", "1", "+", "3", "*"}), equalTo(9));
        assertThat(callMethod(new String[]{"4", "13", "5", "/", "+"}), equalTo(6));
        assertThat(callMethod(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}), equalTo(22));
        assertThat(callMethod(new String[]{"15",  "7",  "1",  "1",  "+",  "-",  "/",  "3",  "*",  "2",  "1",  "1",  "+",  "+",  "-"}), equalTo(5));
    }

}
