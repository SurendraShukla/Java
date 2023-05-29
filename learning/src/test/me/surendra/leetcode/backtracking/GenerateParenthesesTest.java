package me.surendra.leetcode.backtracking;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static me.surendra.TestUtil.assertion;


public class GenerateParenthesesTest {

    private final GenerateParentheses generateParentheses = new GenerateParentheses();

    private List<String> callMethod(final int n) {
//        return generateParentheses.generateParenthesisUsingStringBuilderForBacktracking(n);
        return generateParentheses.generateParenthesisUsingStringForBacktracking(n);
//        return generateParentheses.generateParenthesisUsingIterativeInsertion(n);
    }

    @Test
    public void test1() {
        final List<String> expected = Lists.newArrayList("()");

        assertion(callMethod(1), expected);
    }

    @Test
    public void test2() {
        final List<String> expected = Lists.newArrayList("(())", "()()");

        assertion(callMethod(2), expected);
    }

    @Test
    public void test3() {
        final List<String> expected = Lists.newArrayList("((()))", "(()())", "()(())", "(())()", "()()()");

        assertion(callMethod(3), expected);
    }

    @Test
    public void test4() {
        final List<String> expected = Lists.newArrayList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()");

        assertion(callMethod(4), expected);
    }

}
