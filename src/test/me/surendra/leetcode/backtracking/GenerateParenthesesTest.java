package me.surendra.leetcode.backtracking;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class GenerateParenthesesTest {

    private List<String> callMethod(final int n) {
//        return new GenerateParentheses().generateParenthesisUsingBacktracking(n);
        return new GenerateParentheses().generateParenthesisUsingIterativeInsertion(n);
    }

    @Test
    public void test1() {
        final List<String> expected = Lists.newArrayList("()");

        final List<String> actual = callMethod(1);

        assertion(expected, actual);
    }

    @Test
    public void test2() {
        final List<String> expected = Lists.newArrayList("(())", "()()");

        final List<String> actual = callMethod(2);

        assertion(expected, actual);
    }

    @Test
    public void test3() {
        final List<String> expected = Lists.newArrayList("((()))", "(()())", "()(())", "(())()", "()()()");

        final List<String> actual = callMethod(3);

        assertion(expected, actual);
    }

    @Test
    public void test4() {
        final List<String> expected = Lists.newArrayList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");

        final List<String> actual = callMethod(4);

        assertion(expected, actual);
    }

    private void assertion(final List<String> expected, final List<String> actual) {
        assertThat(actual.size(), equalTo(expected.size()));
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

}