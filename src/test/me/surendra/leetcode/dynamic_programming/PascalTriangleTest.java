package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PascalTriangleTest {

    private List<List<Integer>> callMethod(final int numRows) {
        return new PascalTriangle().generate(numRows);
    }

    @Test
    public void test1() {
        final List<List<Integer>> expected = asList(asList(1));

        final List<List<Integer>> actual = callMethod(1);

        assertion(expected, actual);
    }

    @Test
    public void test2() {
        final List<List<Integer>> expected = asList(asList(1), asList(1,1));

        final List<List<Integer>> actual = callMethod(2);

        assertion(expected, actual);
    }

    @Test
    public void test3() {
        final List<List<Integer>> expected = asList(asList(1), asList(1,1), asList(1,2,1));

        final List<List<Integer>> actual = callMethod(3);

        assertion(expected, actual);
    }

    @Test
    public void test4() {
        final List<List<Integer>> expected = asList(asList(1), asList(1,1), asList(1,2,1), asList(1,3,3,1));

        final List<List<Integer>> actual = callMethod(4);

        assertion(expected, actual);
    }

    @Test
    public void test5() {
        final List<List<Integer>> expected = asList(asList(1), asList(1,1), asList(1,2,1), asList(1,3,3,1), asList(1,4,6,4,1));

        final List<List<Integer>> actual = callMethod(5);

        assertion(expected, actual);
    }

    private void assertion(final List<List<Integer>> expected, final List<List<Integer>> actual) {
        assertThat(actual.size(), equalTo(expected.size()));
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

}
