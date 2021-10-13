package me.surendra.leetcode.backtracking;

import me.surendra.TestUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;


public class GenerateParenthesesTest {

    private List<String> callMethod(final int n) {
        return new GenerateParentheses().generateParenthesisUsingBacktracking(n);
//        return new GenerateParentheses().generateParenthesisUsingIterativeInsertion(n);
    }

    @Test
    public void test1() {
        final List<String> expected = Lists.newArrayList("()");

        final List<String> actual = callMethod(1);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test2() {
        final List<String> expected = Lists.newArrayList("(())", "()()");

        final List<String> actual = callMethod(2);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test3() {
        final List<String> expected = Lists.newArrayList("((()))", "(()())", "()(())", "(())()", "()()()");

        final List<String> actual = callMethod(3);

        TestUtil.assertion(expected, actual);
    }

    @Test
    public void test4() {
        final List<String> expected = Lists.newArrayList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");

        final List<String> actual = callMethod(4);

        TestUtil.assertion(expected, actual);
    }

}
