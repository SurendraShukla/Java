package me.surendra.leetcode.dynamic_programming;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;


public class PascalTriangleTest {

    private final PascalTriangle pascalTriangle = new PascalTriangle();

    private List<List<Integer>> callMethod(final int numRows) {
        return pascalTriangle.generate(numRows);
    }

    @Test
    public void test1() {
        final List<List<Integer>> expected = asList(asList(1));

        final List<List<Integer>> actual = callMethod(1);

        assertThat(expected, Matchers.equalTo(actual));
    }

    @Test
    public void test2() {
        final List<List<Integer>> expected = asList(asList(1), asList(1, 1));

        final List<List<Integer>> actual = callMethod(2);

        assertThat(expected, Matchers.equalTo(actual));
    }

    @Test
    public void test3() {
        final List<List<Integer>> expected = asList(asList(1), asList(1, 1), asList(1, 2, 1));

        final List<List<Integer>> actual = callMethod(3);

        assertThat(expected, Matchers.equalTo(actual));
    }

    @Test
    public void test4() {
        final List<List<Integer>> expected = asList(asList(1), asList(1, 1), asList(1, 2, 1), asList(1, 3, 3, 1));

        final List<List<Integer>> actual = callMethod(4);

        assertThat(expected, Matchers.equalTo(actual));
    }

    @Test
    public void test5() {
        final List<List<Integer>> expected = asList(asList(1), asList(1, 1), asList(1, 2, 1), asList(1, 3, 3, 1), asList(1, 4, 6, 4, 1));

        final List<List<Integer>> actual = callMethod(5);

        assertThat(expected, Matchers.equalTo(actual));
    }

}
